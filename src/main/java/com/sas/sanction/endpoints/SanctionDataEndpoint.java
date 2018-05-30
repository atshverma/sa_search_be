package com.sas.sanction.endpoints;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.sas.sanction.common.Constants;
import com.sas.sanction.dao.CustAccMapNcoreDao;
import com.sas.sanction.entities.AccDimNcore;
import com.sas.sanction.entities.ApplDimNcore;
import com.sas.sanction.entities.BranchDimNcore;
import com.sas.sanction.entities.CustAccMapNcore;
import com.sas.sanction.entities.CustDimNcore;
import com.sas.sanction.entities.CustPtyMapNcore;
import com.sas.sanction.entities.ExtPartyDimNcore;
import com.sas.sanction.entities.FinTranFactNcore;
import com.sas.sanction.entities.ListData;
import com.sas.sanction.entities.MatchingAttributeConfig;
import com.sas.sanction.entities.NonFinTranFactNcore;
import com.sas.sanction.entities.SanctionCustomer;
import com.sas.sanction.entities.SanctionCustomerRequest;
import com.sas.sanction.entities.SanctionCustomerResponse;
import com.sas.sanction.entities.StaffDimNcore;
import com.sas.sanction.entities.TranDimNcore;
import com.sas.sanction.service.AccDimNcoreService;
import com.sas.sanction.service.ApplDimNcoreService;
import com.sas.sanction.service.BranchDimNcoreService;
import com.sas.sanction.service.CustDimNcoreService;
import com.sas.sanction.service.ExtPartyDimNcoreService;
import com.sas.sanction.service.ListDataService;
import com.sas.sanction.service.MatchingAttributeConfigService;
import com.sas.sanction.service.SanctionCustomerRequestService;
import com.sas.sanction.service.SanctionCustomerResponseService;
import com.sas.sanction.service.SanctionCustomerService;
import com.sas.sanction.service.StaffDimNcoreService;
import com.sas.sanction.service.TransactionService;
import com.sas.sanction.webservices.SanctionRequest;
import com.sas.sanction.webservices.SanctionRequest.AccountInfo;
import com.sas.sanction.webservices.SanctionRequest.ApplicationInfo;
import com.sas.sanction.webservices.SanctionRequest.BranchInfo;
import com.sas.sanction.webservices.SanctionRequest.CustomerInfo;
import com.sas.sanction.webservices.SanctionRequest.ExternalPartyInfo;
import com.sas.sanction.webservices.SanctionRequest.StaffInfo;
import com.sas.sanction.webservices.SanctionResponse;

@PropertySource("classpath:resource.properties")
@Endpoint
public class SanctionDataEndpoint {
	private static final String NAMESPACE_URI = "http://www.sanction.sas.com/webservices";
	private static final String CREATED_BY = "SANCTIONREQUEST";
	private static final String UPDATED_BY = "SANCTIONREQUEST";
	private static final String RESPONSE_CODE_SUCCESS = "200";
	private static final String RESPONSE_DESC_SUCCESS = "OK";
	private Logger logger = Logger.getLogger(SanctionDataEndpoint.class);

	@Autowired
	private Environment environment;
	
	@Autowired
	private SanctionCustomerRequestService sanctionCustomerRequestService;

	@Autowired
	private ListDataService listDataService;

	@Autowired
	private SanctionCustomerService sanctionCustomerService;

	@Autowired
	private SanctionCustomerResponseService sanctionCustomerResponseService;

	@Autowired
	private MatchingAttributeConfigService matchingAttributeConfigService;
	
	@Autowired
	private TransactionService transactionService;
	
	@Autowired
	private CustDimNcoreService custDimNcoreService;
	
	@Autowired
	private AccDimNcoreService accDimNcoreService;
	
	@Autowired
	private BranchDimNcoreService branchDimNcoreService;
	
	@Autowired
	private StaffDimNcoreService staffDimNcoreService;
	
	@Autowired
	private ExtPartyDimNcoreService extPartyDimNcoreService;
	
	@Autowired
	private ApplDimNcoreService applDimNcoreService;
	
	@Autowired
	private CustAccMapNcoreDao mapDao;
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "sanctionRequest")
	@ResponsePayload
	public SanctionResponse getSanctionData(@RequestPayload SanctionRequest request) {
		logger.info("Processing Sanction Web Service Request.....");
		SanctionResponse sanctionResponse = new SanctionResponse();
		
		Map<String, String> requestMap = getRequestMap(request);
		
		logger.info("Transaction Type: " + request.getTransactionInfo().getTranxCat());
		//Code started for put data in RSKNCORE
		if(request.getTransactionInfo().getTranxCat().equalsIgnoreCase("FINANCIAL"))
		{
			logger.info("Preparing Financial Data To Process Web Service Request.....");
			CustDimNcore custDimNcore = prepareCustDimNcore(request, custDimNcoreService);
			AccDimNcore accDimNcore = prepareAccDimNcore(request, accDimNcoreService);
			BranchDimNcore branchDimNcore = prepareBranchDimNcore(request, branchDimNcoreService);
			StaffDimNcore staffDimNcore = prepareStaffDimNcore(request, staffDimNcoreService);
			ExtPartyDimNcore extPartyDimNcore = prepareExtPartyDimNcore(request, extPartyDimNcoreService);
			TranDimNcore tranDimNcore = prepareTranDimNcore(request);
			custDimNcore.getAccDimNcores().add(accDimNcore);
			custDimNcore.getExtPartyDimNcores().add(extPartyDimNcore);
			
			FinTranFactNcore finTranFactNcore = prepareFinTranFactNcore(request);
			custDimNcore.addFinTranFactNcore(finTranFactNcore);
			accDimNcore.addFinTranFactNcore(finTranFactNcore);
			branchDimNcore.addFinTranFactNcore(finTranFactNcore);
			staffDimNcore.addFinTranFactNcore(finTranFactNcore);
			extPartyDimNcore.addFinTranFactNcore(finTranFactNcore);
			tranDimNcore.setFinTranFactNcore(finTranFactNcore);
			
			logger.info("Saving Financial Details To Process Web Service Request.....");
			transactionService.saveFinancialTransaction(custDimNcore, accDimNcore, branchDimNcore, staffDimNcore, extPartyDimNcore, tranDimNcore, finTranFactNcore);
		}
		else if(request.getTransactionInfo().getTranxCat().equalsIgnoreCase("NONFINANCIAL"))
		{
			logger.info("Preparing Non Financial Data To Process Web Service Request.....");
			AccDimNcore accDimNcore = prepareAccDimNcore(request, accDimNcoreService);
			BranchDimNcore branchDimNcore = prepareBranchDimNcore(request, branchDimNcoreService);
			CustDimNcore custDimNcore = prepareCustDimNcore(request, custDimNcoreService);
			ExtPartyDimNcore extPartyDimNcore = prepareExtPartyDimNcore(request, extPartyDimNcoreService);
			StaffDimNcore staffDimNcore = prepareStaffDimNcore(request, staffDimNcoreService);
			TranDimNcore tranDimNcore = prepareTranDimNcore(request);
			NonFinTranFactNcore nonFinTranFactNcore = prepareNonFinTranFactNcore(request);
			
			custDimNcore.getAccDimNcores().add(accDimNcore);
			custDimNcore.getExtPartyDimNcores().add(extPartyDimNcore);
			
			accDimNcore.addNonFinTranFactNcore(nonFinTranFactNcore);
			branchDimNcore.addNonFinTranFactNcore(nonFinTranFactNcore);
			custDimNcore.addNonFinTranFactNcore(nonFinTranFactNcore);
			extPartyDimNcore.addNonFinTranFactNcore(nonFinTranFactNcore);
			staffDimNcore.addNonFinTranFactNcore(nonFinTranFactNcore);
			tranDimNcore.setNonFinTranFactNcore(nonFinTranFactNcore);
			logger.info("Saving Non Financial Details To Process Web Service Request.....");
			transactionService.saveNonFinancialTransaction(accDimNcore, branchDimNcore, custDimNcore, extPartyDimNcore, staffDimNcore, tranDimNcore, nonFinTranFactNcore);
			
		}
		else if(request.getApplicationInfo().getAccountNum() != null)
		{
			ApplDimNcore applDimNcore = prepareApplDimNcore(request);
			applDimNcoreService.insertApplDimNcore(applDimNcore);
		}
		//Code ended for put data in RSKNCORE
		
		//Code for put data in SanctionCustomerRequest
		logger.info("Saving Sanction Customer Request.....");
		SanctionCustomerRequest sanctionCustomerRequest = sanctionCustomerRequestService
				.insertSanctionCustomerRequest(prepareSanctionCustomerRequest(request));
		
		
		//Code for get data from SanctionCustomer
		logger.info("Getting Sanction Customer Details By Customer ID: " + request.getCustomerInfo().getCustomerId());
		SanctionCustomer sanctionCustomer = sanctionCustomerService
				.getSanctionCustomerByCustomerId(request.getCustomerInfo().getCustomerId());

		logger.info("Sanction Customer : " + sanctionCustomer);
		
		if (sanctionCustomer != null) {
			//Code for sending the response if SanctionCustomer found
			logger.info("Saving Sanction Customer Response.....");
			SanctionCustomerResponse sanctionCustomerResponse = sanctionCustomerResponseService
					.insertSanctionCustomerResponse(prepareSanctionCustomerResponse(request,
							sanctionCustomer.getStatus(), sanctionCustomer.getStatus(),
							sanctionCustomer.getTransactionNo(), sanctionCustomer.getLastName()));
			
			logger.info("Preparing Sanction Response to send to the client.....");
			sanctionResponse = prepareSanctionResponse(request, sanctionCustomer.getCaseId(),
					sanctionCustomer.getStatus(), sanctionCustomer.getTransactionNo(), sanctionCustomer.getListName());
		} else {
			//Code for ListData if SanctionCustomer is not found
			logger.info("Getting List Data Details for Customer ID: " + request.getCustomerInfo().getCustomerId());
			ListData listData = listDataService.getListDataByCustomerId(request.getCustomerInfo().getCustomerId());
			logger.info("List Data: " + listData);
			if (listData != null) {

				logger.info("Saving Sanction Customer Response....");
				SanctionCustomerResponse sanctionCustomerResponse = sanctionCustomerResponseService
						.insertSanctionCustomerResponse(prepareSanctionCustomerResponse(request, listData.getStatus(),
								listData.getCaseId(), listData.getTransactionNo(), listData.getListName()));
				
				logger.info("Preparing Sanction Response to sent to the client....");
				sanctionResponse = prepareSanctionResponse(request, listData.getCaseId(), listData.getStatus(), listData.getTransactionNo(), listData.getListName());

			}
			else
			{
				//Getting matching attribute config data
				logger.info("Getting Matching Attribute Config Data.....");
				List<MatchingAttributeConfig> matchingAttributeConfigDetails = matchingAttributeConfigService.getAllMatchingAttributes();
				
				logger.info("Preparing XML Map.....");
				Map<String, String> xmlMap = getRequestMap(request);
				
				logger.info("Creating Fuzzy Query Based on Matching Attribute Config Data And XML Map");
				String fuzzyQuery = getFuzzyQuery(matchingAttributeConfigDetails, xmlMap);
				
				logger.info("Getting List Data based on fuzzt query: " + fuzzyQuery);
				List<Map<String, Object>> fuzzyListData = listDataService.getListDataForFuzzyLogic(fuzzyQuery, matchingAttributeConfigDetails, xmlMap, sanctionCustomer, request.getTransactionInfo().getTransactionReference().getTranxRefNum());
				
				logger.info("Fuzzy List Data Size: " + fuzzyListData.size());
				if(fuzzyListData.size() > 0)
				{
					//Saving details in SanctionCustomer table
					logger.info("Inserting Sanction Customer Details");
					SanctionCustomer sanctionCust = sanctionCustomerService.insertSanctionCustomer(prepareSanctionCustomer(request));
				}
				else
				{
					logger.info("Inserting Sanction Customer Response.....");
					SanctionCustomerResponse sanctionCustomerResponse = sanctionCustomerResponseService
							.insertSanctionCustomerResponse(prepareSanctionCustomerResponse(request, "NOT FOUND",
									null, null, null));
					
					logger.info("Prepating Sanction Response....");
					sanctionResponse = prepareSanctionResponse(request, "", "NOT FOUND", request.getTransactionInfo().getTransactionReference().getTranxRefNum(), "");
				}
			}
		}
		return sanctionResponse;
	}

	private CustDimNcore prepareCustDimNcore(SanctionRequest request, CustDimNcoreService custDimNcoreService)
	{
		logger.info("Preparing CustDimNcore....");
		logger.info("Finding CustDimNcore for Customer ID: " + request.getCustomerInfo().getCustomerId());
		CustDimNcore custDimNcore = custDimNcoreService.findByCustomerId(request.getCustomerInfo().getCustomerId());
		logger.info("CustDimNcore: " + custDimNcore);
		if(custDimNcore == null)
		{
			custDimNcore = new CustDimNcore();
			custDimNcore.setCreatedBy(CREATED_BY);
			custDimNcore.setCreatedDt(new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
			custDimNcore.setCreatedDtTm(new java.sql.Timestamp(Calendar.getInstance().getTimeInMillis()));
		}
		else
		{
			custDimNcore.setUpdatedBy(UPDATED_BY);
			custDimNcore.setUpdatedDt(new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
			custDimNcore.setUpdatedDtTm(new java.sql.Timestamp(Calendar.getInstance().getTimeInMillis()));
		}
		
		CustomerInfo custInfo = request.getCustomerInfo();
		custDimNcore.setAnnualIncome(Double.parseDouble(custInfo.getAnnualIncome()));
		custDimNcore.setCntryOfCitizenship1Cd(custInfo.getCountryInf().getCountryCitz1Cd());
		custDimNcore.setCntryOfCitizenship1Name(custInfo.getCountryInf().getCountryCitz1Name());
		custDimNcore.setCntryOfCitizenship2Cd(custInfo.getCountryInf().getCountryCitz2Cd());
		custDimNcore.setCntryOfCitizenship2Name(custInfo.getCountryInf().getCountryCitz2Name());
		custDimNcore.setCntryOfResidencyCd(custInfo.getCountryInf().getCountryResiCode());
		custDimNcore.setCntryOfResidencyName(custInfo.getCountryInf().getCountryResidenceName());
		custDimNcore.setContactNum1(Double.parseDouble(custInfo.getContactInfo().getContactNum1()));
		custDimNcore.setContactNum2(Double.parseDouble(custInfo.getContactInfo().getContactNum2()));
		
		custDimNcore.setCustCat(custInfo.getCustCategory());
		custDimNcore.setCustNum(custInfo.getCustomerId());
		custDimNcore.setCustSinceDt(
				custInfo.getCustSinceDt() != null ? custInfo.getCustSinceDt().toGregorianCalendar().getTime() : null);
		custDimNcore.setCustSubCat(custInfo.getCustSubCategory());
		custDimNcore.setDob(custInfo.getDob() != null ? custInfo.getDob().toGregorianCalendar().getTime() : null);
		custDimNcore.setEmailId(custInfo.getContactInfo().getPrimaryEmailId());
		custDimNcore.setEmploymentTypCat(custInfo.getEmployeeInfo().getEmpTypeCategory());
		custDimNcore.setEmploymentTypSubCat(custInfo.getEmployeeInfo().getEmpTypeSubCatg());
		custDimNcore.setFirstName(custInfo.getFirstName());
		custDimNcore.setFourthName(custInfo.getFourthName());
		custDimNcore.setFullName(custInfo.getFullName());
		custDimNcore.setIdNum1(custInfo.getIdnum1());
		custDimNcore.setIdNum2(custInfo.getIdnum2());
		custDimNcore.setIdTyp1(custInfo.getIdtype1());
		custDimNcore.setIdTyp2(custInfo.getIdtype2());
		custDimNcore.setLastContactDt(
				custInfo.getLastContDate() != null ? custInfo.getLastContDate().toGregorianCalendar().getTime() : null);
		custDimNcore.setLastName(custInfo.getLastName());
		custDimNcore.setLastRiskAssessmentDt(
				custInfo.getLastRiskAssDt() != null ? custInfo.getLastRiskAssDt().toGregorianCalendar().getTime() : null);
		custDimNcore.setLastSuspiciousActivityRptDt(
				custInfo.getLastSusActRptDt() != null ? custInfo.getLastSusActRptDt().toGregorianCalendar().getTime() : null);
		custDimNcore.setLastSuspiciousTxnRptDt(
				custInfo.getLastSusTxnRptDt() != null ? custInfo.getLastSusTxnRptDt().toGregorianCalendar().getTime() : null);
		custDimNcore.setMailingAddrCity(custInfo.getContactInfo().getMailingInfo().getCity());
		custDimNcore.setMailingAddrCntryCd(custInfo.getContactInfo().getMailingInfo().getCountrycode());
		custDimNcore.setMailingAddrCntryName(custInfo.getContactInfo().getMailingInfo().getCountryname());
		custDimNcore.setMailingAddrLine1(custInfo.getContactInfo().getMailingInfo().getAddress1());
		custDimNcore.setMailingAddrLine2(custInfo.getContactInfo().getMailingInfo().getAddress2());
		custDimNcore.setMailingAddrLine3(custInfo.getContactInfo().getMailingInfo().getAddress3());
		custDimNcore.setMailingAddrPostalCd(custInfo.getContactInfo().getMailingInfo().getPostcode());
		custDimNcore.setMailingAddrState(custInfo.getContactInfo().getMailingInfo().getState());
		custDimNcore.setMaritalStatus(custInfo.getMaritalStatus());
		custDimNcore.setNetWorthVal(Double.parseDouble(custInfo.getNetWorthVal()));
		custDimNcore.setOrg1Name(custInfo.getEmployeeInfo().getOrgname1());
		custDimNcore.setOrg1RegistrationNum(custInfo.getEmployeeInfo().getOrg1Registnum());
		custDimNcore.setOrg2Name(custInfo.getEmployeeInfo().getOrgname2());
		custDimNcore.setOrg2RegistrationNum(custInfo.getEmployeeInfo().getOrg2Registnum());
		custDimNcore.setPepFlag(custInfo.getPepflag());
		custDimNcore.setResidentialAddrCity(custInfo.getContactInfo().getResidentialInfo().getCity());
		custDimNcore.setResidentialAddrCntryCd(custInfo.getContactInfo().getResidentialInfo().getCountrycode());
		custDimNcore.setResidentialAddrCntryName(custInfo.getContactInfo().getResidentialInfo().getCountryname());
		custDimNcore.setResidentialAddrLine1(custInfo.getContactInfo().getResidentialInfo().getAddress1());
		custDimNcore.setResidentialAddrLine2(custInfo.getContactInfo().getResidentialInfo().getAddress2());
		custDimNcore.setResidentialAddrLine3(custInfo.getContactInfo().getResidentialInfo().getAddress3());
		custDimNcore.setResidentialAddrPostalCd(custInfo.getContactInfo().getResidentialInfo().getPostcode());
		custDimNcore.setResidentialAddrState(custInfo.getContactInfo().getResidentialInfo().getState());
		custDimNcore.setRiskCat(custInfo.getRiskCat());
		custDimNcore.setSecondName(custInfo.getSecondName());
		custDimNcore.setSegmentName(custInfo.getSegmentName());
		custDimNcore.setStaffFlag(custInfo.getStaflag());
		custDimNcore.setTaxId(custInfo.getTaxid());
		custDimNcore.setThirdName(custInfo.getThirdName());
		return custDimNcore;
	}

	private ApplDimNcore prepareApplDimNcore(SanctionRequest request) {
		logger.info("Preparing ApplDimNcore.......");
		ApplDimNcore applDimNcore = applDimNcoreService.findByCustomerId(request.getApplicationInfo().getCustNum());
		
		if(applDimNcore == null)
		{
			applDimNcore = new ApplDimNcore();
			applDimNcore.setCreatedBy(CREATED_BY);
			applDimNcore.setCreatedDt(new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
			applDimNcore.setCreatedDtTm(new java.sql.Timestamp(Calendar.getInstance().getTimeInMillis()));
		}
		else
		{
			applDimNcore.setUpdatedBy(UPDATED_BY);
			applDimNcore.setUpdatedDt(new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
			applDimNcore.setUpdatedDtTm(new java.sql.Timestamp(Calendar.getInstance().getTimeInMillis()));
		}
	
		ApplicationInfo applicationDetails = request.getApplicationInfo();
		applDimNcore.setAccNum(applicationDetails.getAccountNum());
		applDimNcore.setAnnualIncome(Double.parseDouble(applicationDetails.getEmployeeInfo().getAnnualIncome()));
		applDimNcore.setApplApprovalRejectDttm(applicationDetails.getAppRejectedDtm() != null
				? new java.sql.Timestamp(applicationDetails.getAppRejectedDtm().toGregorianCalendar().getTimeInMillis())
				: null);
		applDimNcore.setApplFullName(applicationDetails.getFullName());
		applDimNcore.setApplIdentificationId(applicationDetails.getAppIdenId());
		applDimNcore.setApplIdentificationTyp(applicationDetails.getAppIdenType());
		applDimNcore.setApplModDttm(applicationDetails.getAppmodDtm() != null
				? new java.sql.Timestamp(applicationDetails.getAppmodDtm().toGregorianCalendar().getTimeInMillis())
				: null);
		applDimNcore.setApplNum(applicationDetails.getApplicationNum());
		applDimNcore.setApplRequestDttm(applicationDetails.getAppRequestedDtm() != null
				? new java.sql.Timestamp(applicationDetails.getAppRequestedDtm().toGregorianCalendar().getTimeInMillis())
				: null);
		applDimNcore.setApplStatusCat(applicationDetails.getAppStatusCat());
		applDimNcore.setApplStatusSubCat(applicationDetails.getAppStatusSubCat());
		applDimNcore.setApplTyp(applicationDetails.getApplicationType());
		applDimNcore.setApprovedByUserId(applicationDetails.getApproveByUid());
		applDimNcore.setChannelId(applicationDetails.getChannelId());
		applDimNcore.setChannelName(applicationDetails.getChannelName());
		applDimNcore.setCntryOfCitizenship1Cd(applicationDetails.getCountryInf().getCountryCitz1Cd());
		applDimNcore.setCntryOfCitizenship1Name(applicationDetails.getCountryInf().getCountryCitz1Name());
		applDimNcore.setCntryOfCitizenship2Cd(applicationDetails.getCountryInf().getCountryCitz2Cd());
		applDimNcore.setCntryOfCitizenship2Name(applicationDetails.getCountryInf().getCountryCitz2Name());
		applDimNcore.setCntryOfResidencyCd(applicationDetails.getContactInfo().getResidentialInfo().getCountrycode());
		applDimNcore.setCntryOfResidencyName(applicationDetails.getContactInfo().getResidentialInfo().getCountryname());
		applDimNcore.setContactNum1(Double.parseDouble(applicationDetails.getContactInfo().getContactNum1()));
		applDimNcore.setContactNum2(Double.parseDouble(applicationDetails.getContactInfo().getContactNum2()));
		applDimNcore.setCreatedBy(CREATED_BY);
		applDimNcore.setCreatedDt(new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
		applDimNcore.setCreatedDtTm(new java.sql.Timestamp(Calendar.getInstance().getTimeInMillis()));
		applDimNcore.setCustNum(applicationDetails.getCustNum());
		applDimNcore.setDesignation(applicationDetails.getEmployeeInfo().getDesignation());
		applDimNcore.setDob(applicationDetails.getDob() != null ? new java.sql.Date(applicationDetails.getDob().toGregorianCalendar().getTimeInMillis()) : null);
		applDimNcore.setEmailId(applicationDetails.getContactInfo().getEmailId());
		applDimNcore.setEmployerCat(applicationDetails.getEmployeeInfo().getEmpTypeCategory());
		applDimNcore.setEmployerName(applicationDetails.getEmployeeInfo().getEmployerName());
		applDimNcore.setFirstName(applicationDetails.getFirstName());
		applDimNcore.setFourthName(applicationDetails.getFourthName());
		applDimNcore.setLastName(applicationDetails.getLastName());
		applDimNcore.setLinkedAccNum(applicationDetails.getLinkAccnum());
		applDimNcore.setMailingAddrCity(applicationDetails.getContactInfo().getMailingInfo().getCity());
		applDimNcore.setMailingAddrCntryCd(applicationDetails.getContactInfo().getMailingInfo().getCountrycode());
		applDimNcore.setMailingAddrCntryName(applicationDetails.getContactInfo().getMailingInfo().getCountryname());
		applDimNcore.setMailingAddrLine1(applicationDetails.getContactInfo().getMailingInfo().getAddress1());
		applDimNcore.setMailingAddrLine2(applicationDetails.getContactInfo().getMailingInfo().getAddress2());
		applDimNcore.setMailingAddrLine3(applicationDetails.getContactInfo().getMailingInfo().getAddress3());
		applDimNcore.setMailingAddrPostalCd(applicationDetails.getContactInfo().getMailingInfo().getPostcode());
		applDimNcore.setMailingAddrState(applicationDetails.getContactInfo().getMailingInfo().getState());
		applDimNcore.setMonthlySalary(Double.parseDouble(applicationDetails.getEmployeeInfo().getMontlySalary()));
		applDimNcore.setNationality(applicationDetails.getContactInfo().getNationality());
		applDimNcore.setOccupation(applicationDetails.getOccupation());
		applDimNcore.setOccupationType(applicationDetails.getOccupationType());
		applDimNcore.setOfficeContactNumber(Integer.parseInt(applicationDetails.getEmployeeInfo().getOfficeContactNumber()));
		applDimNcore.setPeriodOfService(applicationDetails.getPeriodService());
		applDimNcore.setRejectedByUserId(applicationDetails.getRejectByUid());
		applDimNcore.setResidentialAddrCity(applicationDetails.getContactInfo().getResidentialInfo().getCity());
		applDimNcore.setResidentialAddrCntryCd(applicationDetails.getContactInfo().getResidentialInfo().getCountrycode());
		applDimNcore.setResidentialAddrCntryName(applicationDetails.getContactInfo().getResidentialInfo().getCountryname());
		applDimNcore.setResidentialAddrLine1(applicationDetails.getContactInfo().getResidentialInfo().getAddress1());
		applDimNcore.setResidentialAddrLine2(applicationDetails.getContactInfo().getResidentialInfo().getAddress2());
		applDimNcore.setResidentialAddrLine3(applicationDetails.getContactInfo().getResidentialInfo().getAddress3());
		applDimNcore.setResidentialAddrPostalCd(applicationDetails.getContactInfo().getResidentialInfo().getPostcode());
		applDimNcore.setResidentialAddrState(applicationDetails.getContactInfo().getResidentialInfo().getState());
		applDimNcore.setResidentId(applicationDetails.getResedentId());
		applDimNcore.setSecondName(applicationDetails.getSecondName());
		applDimNcore.setThirdName(applicationDetails.getThirdName());
		return applDimNcore;
	}

	private AccDimNcore prepareAccDimNcore(SanctionRequest request, AccDimNcoreService accDimNcoreService) 
	{
		logger.info("Preparing AccDimNcore......");
		logger.info("Finding AccDimNcore for Acc Num: " + request.getAccountInfo().getAccountNum());
		AccDimNcore accDimNcore = accDimNcoreService.findByAccNum(request.getAccountInfo().getAccountNum());
		logger.info("AccDimNcore: " + accDimNcore);
		if(accDimNcore == null)
		{
			accDimNcore = new AccDimNcore();
			accDimNcore.setCreatedBy(CREATED_BY);
			accDimNcore.setCreatedDt(new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
			accDimNcore.setCreatedDtTm(new java.sql.Timestamp(Calendar.getInstance().getTimeInMillis()));
		}
		else
		{
			accDimNcore.setUpdatedBy(UPDATED_BY);
			accDimNcore.setUpdatedDt(new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
			accDimNcore.setUpdatedDtTm(new java.sql.Timestamp(Calendar.getInstance().getTimeInMillis()));
		}
		
		AccountInfo accountDetails = request.getAccountInfo();
		accDimNcore.setAccCloseDt(
				accountDetails.getAccCloseDt() != null ? accountDetails.getAccCloseDt().toGregorianCalendar().getTime() : null);
		accDimNcore.setAccCurrCd(accountDetails.getAccCurrCode());
		accDimNcore.setAccCurrName(accountDetails.getAccCurrName());
		accDimNcore.setAccName(accountDetails.getAccountName());
		accDimNcore.setAccNum(accountDetails.getAccountNum());
		accDimNcore.setAccOpenBranchName(accountDetails.getAccopenBrnachName());
		accDimNcore.setAccOpenDt(
				accountDetails.getAccOpenDt() != null ? accountDetails.getAccOpenDt().toGregorianCalendar().getTime() : null);
		accDimNcore.setAccStatus(accountDetails.getAccStatus());
		accDimNcore.setAccSubTyp(accountDetails.getAccSubType());
		accDimNcore.setAccTyp(accountDetails.getAccountType());

		
		accDimNcore.setDormantInd(accountDetails.getDormantInd());
		accDimNcore.setLastDormantDt(
				accountDetails.getLastDormantDate() != null ? accountDetails.getLastDormantDate().toGregorianCalendar().getTime() : null);
		accDimNcore.setLinkedAccNum(accountDetails.getLinkAccnum());
		accDimNcore.setLinkedAccRelation(accountDetails.getLinkAccRelation());
		accDimNcore.setMailingAddrCity(request.getCustomerInfo().getContactInfo().getMailingInfo().getCity());
		accDimNcore.setMailingAddrCntryCd(request.getCustomerInfo().getContactInfo().getMailingInfo().getCountrycode());
		accDimNcore.setMailingAddrCntryName(request.getCustomerInfo().getContactInfo().getMailingInfo().getCountryname());
		accDimNcore.setMailingAddrLine1(request.getCustomerInfo().getContactInfo().getMailingInfo().getAddress1());
		accDimNcore.setMailingAddrLine2(request.getCustomerInfo().getContactInfo().getMailingInfo().getAddress2());
		accDimNcore.setMailingAddrLine3(request.getCustomerInfo().getContactInfo().getMailingInfo().getAddress3());
		accDimNcore.setMailingAddrPostalCd(request.getCustomerInfo().getContactInfo().getMailingInfo().getPostcode());
		accDimNcore.setMailingAddrState(request.getCustomerInfo().getContactInfo().getMailingInfo().getState());
		accDimNcore.setMaturityDt(
				accountDetails.getMaturityDt() != null ? accountDetails.getMaturityDt().toGregorianCalendar().getTime() : null);
		accDimNcore.setOriginalLoanAmtVal(Double.parseDouble(accountDetails.getOrginalLoanAmtVal()));
		accDimNcore.setProductCatName(accountDetails.getProdCatName());
		accDimNcore.setProductSubCatCd1(accountDetails.getProdSubCatcd1());
		accDimNcore.setProductSubCatCd2(accountDetails.getProdSubCatcd2());
		accDimNcore.setSegmentName(accountDetails.getSegmentName());
		accDimNcore.setTaxId(accountDetails.getTaxid());
		return accDimNcore;
	}

	private ExtPartyDimNcore prepareExtPartyDimNcore(SanctionRequest request, ExtPartyDimNcoreService extPartyDimNcoreService) 
	{
		logger.info("Preparing ExtPartyDimNcore.....");
		logger.info("Finding PartyDimNcore for ExtPartyNum: " + request.getExternalPartyInfo().getExtPartyNum());
		ExtPartyDimNcore extPartyDimNcore = extPartyDimNcoreService.findByExtPartyNum(request.getExternalPartyInfo().getExtPartyNum());
		logger.info("ExtPartyDimNcore: " + extPartyDimNcore);
		if(extPartyDimNcore == null)
		{
			extPartyDimNcore = new ExtPartyDimNcore();
			extPartyDimNcore.setCreatedBy(CREATED_BY);
			extPartyDimNcore.setCreatedDt(new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
			extPartyDimNcore.setCreatedDtTm(new java.sql.Timestamp(Calendar.getInstance().getTimeInMillis()));
		}
		else
		{
			extPartyDimNcore.setUpdatedBy(UPDATED_BY);
			extPartyDimNcore.setUpdatedDt(new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
			extPartyDimNcore.setUpdatedDtTm(new java.sql.Timestamp(Calendar.getInstance().getTimeInMillis()));
		}
		
		ExternalPartyInfo extPartyDetails = request.getExternalPartyInfo();
		extPartyDimNcore.setAddrCity(extPartyDetails.getContactInfo().getResidentialInfo().getCity());
		extPartyDimNcore.setAddrCntryCd(extPartyDetails.getContactInfo().getResidentialInfo().getCountrycode());
		extPartyDimNcore.setAddrCntryName(extPartyDetails.getContactInfo().getResidentialInfo().getCountryname());
		extPartyDimNcore.setAddrLine1(extPartyDetails.getContactInfo().getResidentialInfo().getAddress1());
		extPartyDimNcore.setAddrLine2(extPartyDetails.getContactInfo().getResidentialInfo().getAddress2());
		extPartyDimNcore.setAddrLine3(extPartyDetails.getContactInfo().getResidentialInfo().getAddress3());
		extPartyDimNcore.setAddrPostalCd(extPartyDetails.getContactInfo().getResidentialInfo().getPostcode());
		extPartyDimNcore.setAddrState(extPartyDetails.getContactInfo().getResidentialInfo().getState());
		extPartyDimNcore.setAnnualIncome(Double.parseDouble(extPartyDetails.getAnnualIncome()));
		extPartyDimNcore.setCntryOfCitizenship1Cd(extPartyDetails.getCountryInf().getCountryCitz1Cd());
		extPartyDimNcore.setCntryOfCitizenship1Name(extPartyDetails.getCountryInf().getCountryCitz1Name());
		extPartyDimNcore.setCntryOfCitizenship2Cd(extPartyDetails.getCountryInf().getCountryCitz2Cd());
		extPartyDimNcore.setCntryOfCitizenship2Name(extPartyDetails.getCountryInf().getCountryCitz2Name());
		extPartyDimNcore.setCntryOfResidencyCd(extPartyDetails.getCountryInf().getCountryResiCode());
		extPartyDimNcore.setCntryOfResidencyName(extPartyDetails.getCountryInf().getCountryResidenceName());
		extPartyDimNcore.setContactNum(extPartyDetails.getContactInfo().getContactNum1());
		extPartyDimNcore.setCreatedBy(CREATED_BY);
		extPartyDimNcore.setCreatedDt(new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
		extPartyDimNcore.setCreatedDtTm(new java.sql.Timestamp(Calendar.getInstance().getTimeInMillis()));
		extPartyDimNcore.setDob(
				extPartyDetails.getDob() != null ? extPartyDetails.getDob().toGregorianCalendar().getTime() : null);
		extPartyDimNcore.setEmailId(extPartyDetails.getContactInfo().getPrimaryEmailId());
		extPartyDimNcore.setExtPartyCat(extPartyDetails.getExtPartyCat());
		extPartyDimNcore.setExtPartyNum(extPartyDetails.getExtPartyNum());
		extPartyDimNcore.setExtPartySubCat(extPartyDetails.getExtPartySubCat());
		extPartyDimNcore.setFirstName(extPartyDetails.getFirstName());
		extPartyDimNcore.setFourthName(extPartyDetails.getFourthName());
		extPartyDimNcore.setFullName(extPartyDetails.getFullName());
		extPartyDimNcore.setIdNum1(extPartyDetails.getIdnum1());
		extPartyDimNcore.setIdTyp1(extPartyDetails.getIdtyp1());
		extPartyDimNcore.setLastName(extPartyDetails.getLastName());
		extPartyDimNcore.setNetWorthVal(Double.parseDouble(extPartyDetails.getNetWorthVal()));
		extPartyDimNcore.setOrgName(extPartyDetails.getOrgname());
		extPartyDimNcore.setOrgRegisterationNum(null);
		extPartyDimNcore.setPepFlag(null);
		extPartyDimNcore.setRiskCat(extPartyDetails.getRiskCat());
		extPartyDimNcore.setRiskSubCat(extPartyDetails.getRiskSubCat());
		extPartyDimNcore.setSecondName(extPartyDetails.getSecondName());
		extPartyDimNcore.setSegmentName(extPartyDetails.getSegmentName());
		extPartyDimNcore.setThirdName(extPartyDetails.getThirdName());
		return extPartyDimNcore;
	}

	private BranchDimNcore prepareBranchDimNcore(SanctionRequest request, BranchDimNcoreService branchDimNcoreService) 
	{
		logger.info("Preparing BranchDimNcore.....");
		logger.info("Finding Branch Dim Ncore For Branch Num: " + request.getBranchInfo().getBranchNum());
		BranchDimNcore branchDimNcore = branchDimNcoreService.findByBranchNum(request.getBranchInfo().getBranchNum());
		logger.info("BranchDimNcore: " + branchDimNcore);
		
		if(branchDimNcore == null)
		{
			branchDimNcore = new BranchDimNcore();
			branchDimNcore.setCreatedBy(CREATED_BY);
			branchDimNcore.setCreatedDt(new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
			branchDimNcore.setCreatedDtTm(new java.sql.Timestamp(Calendar.getInstance().getTimeInMillis()));
		}
		else
		{
			branchDimNcore.setUpdatedBy(UPDATED_BY);
			branchDimNcore.setUpdatedDt(new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
			branchDimNcore.setUpdatedDtTm(new java.sql.Timestamp(Calendar.getInstance().getTimeInMillis()));
		}
		BranchInfo branch = request.getBranchInfo();
		branchDimNcore.setAddrCity(branch.getBranchConinfo().getCity());
		branchDimNcore.setAddrCntryCd(branch.getBranchConinfo().getCountrycode());
		branchDimNcore.setAddrCntryName(branch.getBranchConinfo().getCountryname());
		branchDimNcore.setAddrLine1(branch.getBranchConinfo().getAddress1());
		branchDimNcore.setAddrLine2(branch.getBranchConinfo().getAddress2());
		branchDimNcore.setAddrLine3(branch.getBranchConinfo().getAddress3());
		branchDimNcore.setAddrPostalCd(branch.getBranchConinfo().getZipcode());
		branchDimNcore.setAddrState(branch.getBranchConinfo().getState());
		branchDimNcore.setBranchCat(branch.getBranchCatg());
		branchDimNcore.setBranchContactName(branch.getBranchContactName());
		branchDimNcore.setBranchContactNum(Double.parseDouble(branch.getBranchContactNum()));
		branchDimNcore.setBranchSubCat(branch.getBranchSubCatg());
		branchDimNcore.setSegmentName(branch.getSegmentName());
		return branchDimNcore;
	}

	private StaffDimNcore prepareStaffDimNcore(SanctionRequest request, StaffDimNcoreService staffDimNcoreService)
	{
		logger.info("Preparing StaffDimNcore......");
		logger.info("Finding StaffDimNcore for Staff Num: " + request.getStaffInfo().getStaffNum());
		StaffDimNcore staffDimNcore = staffDimNcoreService.findByStaffNum(request.getStaffInfo().getStaffNum());
		logger.info("StaffDimNcore: " + staffDimNcore);
		
		if(staffDimNcore == null)
		{
			staffDimNcore = new StaffDimNcore();
			staffDimNcore.setCreatedBy(CREATED_BY);
			staffDimNcore.setCreatedDt(new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
			staffDimNcore.setCreatedDtTm(new java.sql.Timestamp(Calendar.getInstance().getTimeInMillis()));
		}
		else
		{
			staffDimNcore.setUpdatedBy(CREATED_BY);
			staffDimNcore.setUpdatedDt(new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
			staffDimNcore.setUpdatedDtTm(new java.sql.Timestamp(Calendar.getInstance().getTimeInMillis()));
		}
		StaffInfo staff = request.getStaffInfo();
		staffDimNcore.setAnnualIncome(Double.parseDouble(staff.getAnnualIncome()));
		staffDimNcore.setCntryOfCitizenship1Cd(staff.getCountryInf().getCountryCitz1Cd());
		staffDimNcore.setCntryOfCitizenship1Name(staff.getCountryInf().getCountryCitz1Name());
		staffDimNcore.setCntryOfCitizenship2Cd(staff.getCountryInf().getCountryCitz2Cd());
		staffDimNcore.setCntryOfCitizenship2Name(staff.getCountryInf().getCountryCitz2Name());
		staffDimNcore.setCntryOfResidencyCd(staff.getCountryInf().getCountryResiCode());
		staffDimNcore.setCntryOfResidencyName(staff.getCountryInf().getCountryResidenceName());
		staffDimNcore.setContactNum1(Double.parseDouble(staff.getContactInfo().getContactNum1()));
		staffDimNcore.setContactNum2(Double.parseDouble(staff.getContactInfo().getContactNum2()));
		
		staffDimNcore.setDob(staff.getDob() != null ? staff.getDob().toGregorianCalendar().getTime() : null);
		staffDimNcore.setEmailId(staff.getContactInfo().getEmailId());
		staffDimNcore.setFirstName(staff.getFirstName());
		staffDimNcore.setFourthName(staff.getFourthName());
		staffDimNcore.setFullName(staff.getFullName());
		staffDimNcore.setIdNum1(staff.getIdnum1());
		staffDimNcore.setIdNum2(staff.getIdnum2());
		staffDimNcore.setIdTyp1(staff.getIdtype1());
		staffDimNcore.setIdTyp2(staff.getIdtyp2());
		staffDimNcore.setLastName(staff.getLastName());
		staffDimNcore.setLastRiskAssessmentDt(staff.getLastRiskAssDt() != null ? new java.sql.Date(staff.getLastRiskAssDt().toGregorianCalendar().getTimeInMillis()) : null);
		staffDimNcore.setLastSuspiciousActivityRptDt(staff.getLastSusActRptDt() != null ? new java.sql.Date(staff.getLastSusActRptDt().toGregorianCalendar().getTimeInMillis()) : null);
		staffDimNcore.setLastSuspiciousTxnRptDt(staff.getLastSusTxnRptDt() != null ? new java.sql.Date(staff.getLastSusTxnRptDt().toGregorianCalendar().getTimeInMillis()) : null);
		staffDimNcore.setMailingAddrCity(staff.getContactInfo().getMailingInfo().getCity());
		staffDimNcore.setMailingAddrCntryCd(staff.getContactInfo().getMailingInfo().getCountrycode());
		staffDimNcore.setMailingAddrCntryName(staff.getContactInfo().getMailingInfo().getCountryname());
		staffDimNcore.setMailingAddrLine1(staff.getContactInfo().getMailingInfo().getAddress1());
		staffDimNcore.setMailingAddrLine2(staff.getContactInfo().getMailingInfo().getAddress2());
		staffDimNcore.setMailingAddrLine3(staff.getContactInfo().getMailingInfo().getAddress3());
		staffDimNcore.setMailingAddrPostalCd(staff.getContactInfo().getMailingInfo().getPostcode());
		staffDimNcore.setMailingAddrState(staff.getContactInfo().getMailingInfo().getState());
		staffDimNcore.setMaritalStatus(staff.getMaritalStatus());
		staffDimNcore.setNetWorthVal(Double.parseDouble(staff.getNetworthVal()));
		staffDimNcore.setPepFlag(staff.getPepFlag());
		staffDimNcore.setResidentialAddrCity(staff.getContactInfo().getResidentialInfo().getCity());
		staffDimNcore.setResidentialAddrCntryCd(staff.getContactInfo().getResidentialInfo().getCountrycode());
		staffDimNcore.setResidentialAddrCntryName(staff.getContactInfo().getResidentialInfo().getCountryname());
		staffDimNcore.setResidentialAddrLine1(staff.getContactInfo().getResidentialInfo().getAddress1());
		staffDimNcore.setResidentialAddrLine2(staff.getContactInfo().getResidentialInfo().getAddress2());
		staffDimNcore.setResidentialAddrLine3(staff.getContactInfo().getResidentialInfo().getAddress3());
		staffDimNcore.setResidentialAddrPostalCd(staff.getContactInfo().getResidentialInfo().getPostcode());
		staffDimNcore.setResidentialAddrState(staff.getContactInfo().getResidentialInfo().getState());
		staffDimNcore.setRiskCat(staff.getRiskCat());
		staffDimNcore.setRiskSubCat(staff.getRiskSubCat());
		staffDimNcore.setSecondName(staff.getSecondName());
		staffDimNcore.setSegmentName(staff.getSegmentName());
		staffDimNcore.setStaffCat(staff.getStaffCatg());
		staffDimNcore.setStaffNum(staff.getStaffNum());
		staffDimNcore.setStaffSinceDt(staff.getStaffSinceDt() != null ? new java.sql.Date(staff.getStaffSinceDt().toGregorianCalendar().getTimeInMillis()) : null);
		staffDimNcore.setStaffSubCat(staff.getStaffSubCatg());
		staffDimNcore.setTaxId(staff.getTaxid());
		staffDimNcore.setThirdName(staff.getThirdName());
		return staffDimNcore;
	}

	//No XML tags found for this method - Clarification nee
	/*private CntryCurrLkpNcore prepareCntryCurrLkpNcore(SanctionRequest request) {
		CntryCurrLkpNcore cntryLookup = new CntryCurrLkpNcore();
		cntryLookup.setCntryCd(request.ge);
		cntryLookup.setCntryCd3(request.getCountrycur().getCcode3());
		cntryLookup.setCntryName(request.getCountrycur().getCnname());
		cntryLookup.setCntryNum(Double.parseDouble(request.getCountrycur().getCnnum()));
		cntryLookup.setCurrCd(request.getCountrycur().getCurcode());
		return cntryLookup;
	}*/

	
	//No XML tags found for this method - Clarification needed
	/*private TxnFactNcore prepareTxnFactNcore(SanctionRequest request) {
		request.getTransactionInfo()
		TxnFactNcore txnFactNcore = new TxnFactNcore();
		txnFactNcore.setChannelMed(request.getTransactionInfo().getTransactionReference().get);
		txnFactNcore.setChannelName(request.getTransactionInfo().getTransactionReference().get);
		txnFactNcore.setCreatedBy(CREATED_BY);
		txnFactNcore.setCreatedDt(new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
		txnFactNcore.setCreatedDttm(new java.sql.Timestamp(Calendar.getInstance().getTimeInMillis()));
		txnFactNcore.setProductMed(transactionType.getProdmed());
		txnFactNcore.setProductName(transactionType.getProdname());
		txnFactNcore.setServiceName(transactionType.getServname());
		txnFactNcore.setTxnCat(transactionType.getTxncat());
		txnFactNcore.setTxnTypFlag(transactionType.getTxnflag());
		return txnFactNcore;
	}*/

	private SanctionCustomerRequest prepareSanctionCustomerRequest(SanctionRequest request) {
		logger.info("Preparing SanctionCustomerRequest......");
		SanctionCustomerRequest sanctionCustomerRequest = new SanctionCustomerRequest();
		sanctionCustomerRequest.setCaseId(null); //No XML tag - Needs to verify
		sanctionCustomerRequest.setCountryOfBirth(request.getCustomerInfo().getCountryInf().getCountryOfBirth());
		sanctionCustomerRequest.setCountryOfCitizenship1(request.getCustomerInfo().getCountryInf().getCountryCitz1Name());
		sanctionCustomerRequest.setCountryOfCitizenship2(request.getCustomerInfo().getCountryInf().getCountryCitz2Name());
		sanctionCustomerRequest.setCountryOfNationality(request.getCustomerInfo().getContactInfo().getNationality());
		sanctionCustomerRequest.setCreatedBy(CREATED_BY);
		sanctionCustomerRequest.setCreatedDt(new Date(Calendar.getInstance().getTimeInMillis()));
		sanctionCustomerRequest.setCreatedDttm(new Timestamp(Calendar.getInstance().getTimeInMillis()));
		sanctionCustomerRequest.setCustomerId(request.getCustomerInfo().getCustomerId());
		Date dob = request.getCustomerInfo().getDob() != null
				? new Date(request.getCustomerInfo().getDob().toGregorianCalendar().getTimeInMillis()) : null;
		sanctionCustomerRequest.setDateOfBirth(dob);
		sanctionCustomerRequest.setFirstName(request.getCustomerInfo().getFirstName());
		sanctionCustomerRequest.setFourthName(request.getCustomerInfo().getFourthName());
		sanctionCustomerRequest.setFullName(request.getCustomerInfo().getFullName());
		sanctionCustomerRequest.setLastName(request.getCustomerInfo().getLastName());
		sanctionCustomerRequest.setMailAddressCity(request.getCustomerInfo().getContactInfo().getMailingInfo().getCity());
		sanctionCustomerRequest
				.setMailAddressCountry(request.getCustomerInfo().getContactInfo().getMailingInfo().getCountryname());
		sanctionCustomerRequest.setMailAddressState(request.getCustomerInfo().getContactInfo().getMailingInfo().getState());
		sanctionCustomerRequest.setMailAddressStreetLine1(request.getCustomerInfo().getContactInfo().getMailingInfo().getAddress1());
		sanctionCustomerRequest.setMailAddressStreetLine2(request.getCustomerInfo().getContactInfo().getMailingInfo().getAddress1());
		sanctionCustomerRequest.setMailAddressStreetLine3(request.getCustomerInfo().getContactInfo().getMailingInfo().getAddress1());
		sanctionCustomerRequest.setMailAddressZipCode(request.getCustomerInfo().getContactInfo().getMailingInfo().getPostcode());
		sanctionCustomerRequest.setPhoneNumber1(request.getCustomerInfo().getContactInfo().getContactNum1());
		sanctionCustomerRequest.setPhoneNumber2(request.getCustomerInfo().getContactInfo().getContactNum2());
		sanctionCustomerRequest.setPrimaryEmail(request.getCustomerInfo().getContactInfo().getPrimaryEmailId());
		sanctionCustomerRequest.setResAddressCity(request.getCustomerInfo().getContactInfo().getResidentialInfo().getCity());
		sanctionCustomerRequest.setResAddressCountry(request.getCustomerInfo().getContactInfo().getResidentialInfo().getCountryname());
		sanctionCustomerRequest.setResAddressState(request.getCustomerInfo().getContactInfo().getResidentialInfo().getState());
		sanctionCustomerRequest.setResAddressStreetLine1(request.getCustomerInfo().getContactInfo().getResidentialInfo().getAddress1());
		sanctionCustomerRequest.setResAddressStreetLine2(request.getCustomerInfo().getContactInfo().getResidentialInfo().getAddress1());
		sanctionCustomerRequest.setResAddressStreetLine3(request.getCustomerInfo().getContactInfo().getResidentialInfo().getAddress1());
		sanctionCustomerRequest.setResAddressZipCode(request.getCustomerInfo().getContactInfo().getResidentialInfo().getPostcode());
		sanctionCustomerRequest.setSecondaryEmail(request.getCustomerInfo().getContactInfo().getSecondaryEmailId());
		sanctionCustomerRequest.setSecondName(request.getCustomerInfo().getSecondName());
		sanctionCustomerRequest.setStatus(null); // No tag in XML - needs to verify
		sanctionCustomerRequest.setThirdName(request.getCustomerInfo().getThirdName());
		sanctionCustomerRequest.setTransactionAmount(String.valueOf(request.getTransactionInfo().getTranxAmt())); 
		sanctionCustomerRequest.setTransactionType(request.getTransactionInfo().getTranxType());
		sanctionCustomerRequest.setUniqueId1(request.getCustomerInfo().getIdnum1());
		sanctionCustomerRequest.setUniqueId2(request.getCustomerInfo().getIdnum2());
		return sanctionCustomerRequest;
	}

	private SanctionCustomerResponse prepareSanctionCustomerResponse(SanctionRequest request, String status,
			String caseId, String transactionNo, String listName) {
		logger.info("Preparing SanctionCustomerResponse.....");
		SanctionCustomerResponse sanctionCustomerResponse = new SanctionCustomerResponse();
		sanctionCustomerResponse.setCaseId(caseId); //No tag in XML - Needs to verify
		sanctionCustomerResponse.setCreatedBy(CREATED_BY);
		sanctionCustomerResponse.setCreatedDt(new Date(Calendar.getInstance().getTimeInMillis()));
		sanctionCustomerResponse.setCreatedDttm(new Timestamp(Calendar.getInstance().getTimeInMillis()));
		sanctionCustomerResponse.setCustomerId(request.getCustomerInfo().getCustomerId());
		sanctionCustomerResponse.setListName(listName);
		sanctionCustomerResponse.setResponseCode(RESPONSE_CODE_SUCCESS);
		sanctionCustomerResponse.setResponseDesc(RESPONSE_DESC_SUCCESS);
		sanctionCustomerResponse.setStatus(status); // Needs to verify
		sanctionCustomerResponse.setTransactionNo(transactionNo); // Needs to verify
		return sanctionCustomerResponse;
	}

	private SanctionResponse prepareSanctionResponse(SanctionRequest request, String caseId, String status,
			String transactionNo, String listName) {
		logger.info("Preparing SanctionResponse.....");
		SanctionResponse response = new SanctionResponse();
		response.setCaseId(caseId); // Needs to verify
		response.setCustomerId(request.getCustomerInfo().getCustomerId());
		response.setListName(listName);
		response.setResponseCode(RESPONSE_CODE_SUCCESS);
		response.setResponseDesc(RESPONSE_DESC_SUCCESS);
		response.setStatus(status); // Needs to verify
		response.setTransactionNumber(transactionNo); // Needs to verify
		return response;
	}
	

	private FinTranFactNcore prepareFinTranFactNcore(SanctionRequest request)
	{
		logger.info("Preparing FinTranFactNcore.....");
		FinTranFactNcore finTranFactNcore = new FinTranFactNcore();
		finTranFactNcore.setAccountNumber(request.getAccountInfo().getAccountNum());
		finTranFactNcore.setCreatedBy(CREATED_BY);
		finTranFactNcore.setCreatedDt(new Date(Calendar.getInstance().getTimeInMillis()));
		finTranFactNcore.setCreatedDtTm(new Timestamp(Calendar.getInstance().getTimeInMillis()));
		finTranFactNcore.setCreditDebitFlag(request.getTransactionInfo().getCreditDebitFlag() != null ? request.getTransactionInfo().getCreditDebitFlag().charAt(0) : 0);
		finTranFactNcore.setCustomerNumber(request.getTransactionInfo().getCustNum());
		finTranFactNcore.setRelatedInd(request.getTransactionInfo().getRelatedInd() != null ? request.getTransactionInfo().getRelatedInd().charAt(0) : 0);
		finTranFactNcore.setSecondaryAccountSNumber(0); //No XML tag - Needs to clarify
		finTranFactNcore.setTransactionDestinationCountryNumber(Double.parseDouble(request.getTransactionInfo().getTranxDestCntryNum()));
		finTranFactNcore.setTransactionOriginatingCountryNumber(Double.parseDouble(request.getTransactionInfo().getTranxOrgCntryNum()));
		finTranFactNcore.setTransactionAmountAccountCurrency(Double.parseDouble(request.getTransactionInfo().getTranxAmountAcctCurr()));
		finTranFactNcore.setTransactionAmountLocalCurrency(Double.parseDouble(request.getTransactionInfo().getTrnxAmountLocalcurr()));
		finTranFactNcore.setTransactionAmountTransactionCurrency(Double.parseDouble(request.getTransactionInfo().getTranxAmountTranxcurr()));
		finTranFactNcore.setTransactionExecutedDate(request.getTransactionInfo().getTranxExecDate() != null ? new java.sql.Date(request.getTransactionInfo().getTranxExecDate().toGregorianCalendar().getTimeInMillis()) : null);
		finTranFactNcore.setTransactionExecutedTime(request.getTransactionInfo().getTranxExecutedTime() != null ? new java.sql.Date(request.getTransactionInfo().getTranxExecutedTime().toGregorianCalendar().getTimeInMillis()) : null);
		finTranFactNcore.setTransactionPostedDate(request.getTransactionInfo().getTranxPostedDt() != null ? new java.sql.Date(request.getTransactionInfo().getTranxPostedDt().toGregorianCalendar().getTimeInMillis()) : null);
		finTranFactNcore.setTransactionPostedTime(request.getTransactionInfo().getTranxPosteDtm() != null ? new java.sql.Date(request.getTransactionInfo().getTranxPosteDtm().toGregorianCalendar().getTimeInMillis()) : null);
		return finTranFactNcore;
	}
	
	private NonFinTranFactNcore prepareNonFinTranFactNcore(SanctionRequest request)
	{
		logger.info("Preparing NonFinTranFactNcore....");
		NonFinTranFactNcore nonFinTranFactNcore = new NonFinTranFactNcore();
		nonFinTranFactNcore.setAccountNumber(request.getTransactionInfo().getAccountNum());
		nonFinTranFactNcore.setCreatedBy(CREATED_BY);
		nonFinTranFactNcore.setCreatedDt(new Date(Calendar.getInstance().getTimeInMillis()));
		nonFinTranFactNcore.setCreatedDtTm(new Timestamp(Calendar.getInstance().getTimeInMillis()));
		nonFinTranFactNcore.setCustomerNumber(request.getTransactionInfo().getCustNum());
		nonFinTranFactNcore.setRelatedInd(request.getTransactionInfo().getRelatedInd() != null ? request.getTransactionInfo().getRelatedInd().charAt(0) : 0);
		nonFinTranFactNcore.setSecondaryAccountNumber(null); //No xml tag - Need clarification
		nonFinTranFactNcore.setSecondaryAccountSNumber(0); //No xml Tag - need clarification
		nonFinTranFactNcore.setSecondaryPartyNumber(null);
		nonFinTranFactNcore.setTransactionDestinationCountryNumber(Double.parseDouble(request.getTransactionInfo().getTranxDestCntryNum()));
		nonFinTranFactNcore.setTransactionExecutedDate(request.getTransactionInfo().getTranxExecDate() != null ? new java.sql.Date(request.getTransactionInfo().getTranxExecDate().toGregorianCalendar().getTimeInMillis()) : null);
		nonFinTranFactNcore.setTransactionExecutedTime(request.getTransactionInfo().getTranxExecutedTime() != null ? new java.sql.Date(request.getTransactionInfo().getTranxExecutedTime().toGregorianCalendar().getTimeInMillis()) : null);
		nonFinTranFactNcore.setTransactionOriginatingCountryNumber(Double.parseDouble(request.getTransactionInfo().getTranxOrgCntryNum()));
		nonFinTranFactNcore.setTransactionPostedDate(request.getTransactionInfo().getTranxPostedDt() != null ? new java.sql.Date(request.getTransactionInfo().getTranxPostedDt().toGregorianCalendar().getTimeInMillis()) : null);
		nonFinTranFactNcore.setTransactionPostedTime(request.getTransactionInfo().getTranxPosteDtm() != null ? new java.sql.Date(request.getTransactionInfo().getTranxPosteDtm().toGregorianCalendar().getTimeInMillis()) : null);
		return nonFinTranFactNcore;
		
	}
	
	private Map<String, String> getRequestMap(SanctionRequest request)
	{
		Map<String, String> requestMap = new HashMap<>();
		requestMap.put(Constants.FULL_NAME, request.getCustomerInfo().getFullName());
		requestMap.put(Constants.FIRST_NAME, request.getCustomerInfo().getFirstName());
		requestMap.put(Constants.SECOND_NAME, request.getCustomerInfo().getSecondName());
		requestMap.put(Constants.THIRD_NAME, request.getCustomerInfo().getThirdName());
		requestMap.put(Constants.FOURTH_NAME, request.getCustomerInfo().getFourthName());
		requestMap.put(Constants.LAST_NAME, request.getCustomerInfo().getLastName());
		requestMap.put(Constants.ID_TYPE_1, request.getCustomerInfo().getIdtype1());
		requestMap.put(Constants.ID_NUM_1, request.getCustomerInfo().getIdnum1());
		requestMap.put(Constants.ID_TYPE_2, request.getCustomerInfo().getIdtype2());
		requestMap.put(Constants.COUNTRY_OF_BIRTH, request.getCustomerInfo().getCountryInf().getCountryOfBirth());
		requestMap.put(Constants.EMP_CAT, request.getCustomerInfo().getEmployeeInfo().getEmpTypeCategory());
		requestMap.put(Constants.EMP_SUB_CAT, request.getCustomerInfo().getEmployeeInfo().getEmpTypeSubCatg());
		requestMap.put(Constants.RES_ADD_1, request.getCustomerInfo().getContactInfo().getResidentialInfo().getAddress1());
		requestMap.put(Constants.RES_ADD_2, request.getCustomerInfo().getContactInfo().getResidentialInfo().getAddress2());
		requestMap.put(Constants.RES_ADD_3, request.getCustomerInfo().getContactInfo().getResidentialInfo().getAddress3());
		requestMap.put(Constants.RES_CITY, request.getCustomerInfo().getContactInfo().getResidentialInfo().getCity());
		requestMap.put(Constants.RES_STATE, request.getCustomerInfo().getContactInfo().getResidentialInfo().getState());
		requestMap.put(Constants.RES_POSTAL_CODE, request.getCustomerInfo().getContactInfo().getResidentialInfo().getPostcode());
		requestMap.put(Constants.RES_COUNTRY, request.getCustomerInfo().getContactInfo().getResidentialInfo().getCountryname());
		requestMap.put(Constants.MAIL_ADD_1, request.getCustomerInfo().getContactInfo().getMailingInfo().getAddress1());
		requestMap.put(Constants.MAIL_ADD_2, request.getCustomerInfo().getContactInfo().getMailingInfo().getAddress2());
		requestMap.put(Constants.MAIL_ADD_3, request.getCustomerInfo().getContactInfo().getMailingInfo().getAddress3());
		requestMap.put(Constants.MAIL_CITY, request.getCustomerInfo().getContactInfo().getMailingInfo().getCity());
		requestMap.put(Constants.MAIL_STATE, request.getCustomerInfo().getContactInfo().getMailingInfo().getState());
		requestMap.put(Constants.MAIL_POSTAL_CODE, request.getCustomerInfo().getContactInfo().getMailingInfo().getPostcode());
		requestMap.put(Constants.MAIL_COUNTRY, request.getCustomerInfo().getContactInfo().getMailingInfo().getCountryname());
		requestMap.put(Constants.CONTACT_NUM_1, request.getCustomerInfo().getContactInfo().getContactNum1());
		requestMap.put(Constants.CONTACT_NUM_2, request.getCustomerInfo().getContactInfo().getContactNum2());
		return requestMap;
	}
	
	private TranDimNcore prepareTranDimNcore(SanctionRequest request)
	{
		
		logger.info("Preparing TranDimNcore.....");
		TranDimNcore tranDimNcore = new TranDimNcore();
		tranDimNcore.setChannelId(request.getTransactionInfo().getTransactionReference().getChannelId());
		tranDimNcore.setChannelName(request.getTransactionInfo().getTransactionReference().getChannelName());
		tranDimNcore.setCreatedBy(CREATED_BY);
		tranDimNcore.setCreatedDt(new Date(Calendar.getInstance().getTimeInMillis()));
		tranDimNcore.setCreatedDtTm(new Timestamp(Calendar.getInstance().getTimeInMillis()));
		tranDimNcore.setNarrative1(request.getTransactionInfo().getTransactionReference().getNarrative1());
		tranDimNcore.setNarrative2(request.getTransactionInfo().getTransactionReference().getNarrative2());
		tranDimNcore.setNarrative3(request.getTransactionInfo().getTransactionReference().getNarrative3());
		tranDimNcore.setTxnPtrnNum(request.getTransactionInfo().getTransactionReference().getTranxPatternNum());
		tranDimNcore.setTxnRefNum(request.getTransactionInfo().getTransactionReference().getTranxRefNum());
		tranDimNcore.setTxnStatus(request.getTransactionInfo().getTransactionReference().getTranxStatus());
		return tranDimNcore;
	}
	
	private String getFuzzyQuery(List<MatchingAttributeConfig> matchingAttributeConfigDetails, Map<String, String> map)
	{
		String fuzzyQuerySelect = "SELECT LIST_NAME, ";
		String fuzzyQueryFrom = " FROM sanctiondb.sanction.list_data WHERE ";
		String fuzzyQuery = null;
		//Adding column names for Select
		for(MatchingAttributeConfig config : matchingAttributeConfigDetails)
		{
			fuzzyQuerySelect += config.getRequestAttributeName() + ", ";
		}
		
		if(fuzzyQuerySelect.endsWith(", "))
			fuzzyQuerySelect = fuzzyQuerySelect.substring(0, fuzzyQuerySelect.length() - 2);
		
		//Adding column names for where clause
		for(MatchingAttributeConfig config : matchingAttributeConfigDetails)
		{
			if(config.getMatchType().equalsIgnoreCase("DIRECT"))
				//fuzzyQueryFrom += config.getRequestAttributeName() + " = '" + map.get(environment.getProperty(config.getRequestAttributeName())) + "' AND ";
				fuzzyQueryFrom += config.getRequestAttributeName() + " = '" + map.get(config.getRequestAttributeName()) + "' AND ";
			else
				fuzzyQueryFrom += "SOUNDEX(" + config.getRequestAttributeName() + ") = " + "SOUNDEX('" + map.get(config.getRequestAttributeName()) + "') AND ";
		}
		
		if(fuzzyQueryFrom.endsWith(" AND "))
			fuzzyQueryFrom = fuzzyQueryFrom.substring(0, fuzzyQueryFrom.length() - 5);
		
		return fuzzyQuerySelect + fuzzyQueryFrom;
	}
	
	private SanctionCustomer prepareSanctionCustomer(SanctionRequest request)
	{
		logger.info("Preparing SanctionCustomer......");
		SanctionCustomer sanctionCustomer = new SanctionCustomer();
		sanctionCustomer.setCaseId(null);
		sanctionCustomer.setCountryOfBirth(request.getCustomerInfo().getCountryInf().getCountryOfBirth());
		sanctionCustomer.setCountryOfCitizenship1(request.getCustomerInfo().getCountryInf().getCountryCitz1Name());
		sanctionCustomer.setCountryOfCitizenship2(request.getCustomerInfo().getCountryInf().getCountryCitz2Name());
		sanctionCustomer.setCountryOfNationality(request.getCustomerInfo().getContactInfo().getNationality());
		sanctionCustomer.setCreatedBy(CREATED_BY);
		sanctionCustomer.setCreatedDt(new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
		sanctionCustomer.setCreatedDttm(new java.sql.Timestamp(Calendar.getInstance().getTimeInMillis()));
		sanctionCustomer.setCustomerId(request.getCustomerInfo().getCustomerId());
		sanctionCustomer.setDateOfBirth(request.getCustomerInfo().getDob() != null ? new java.sql.Date(request.getCustomerInfo().getDob().toGregorianCalendar().getTimeInMillis()) : null);
		sanctionCustomer.setFirstName(request.getCustomerInfo().getFirstName());
		sanctionCustomer.setFourthName(request.getCustomerInfo().getFourthName());
		sanctionCustomer.setFullName(request.getCustomerInfo().getFullName());
		sanctionCustomer.setLastName(request.getCustomerInfo().getLastName());
		sanctionCustomer.setListName("GREY_LIST");
		sanctionCustomer.setMailAddressCity(request.getCustomerInfo().getContactInfo().getMailingInfo().getCity());
		sanctionCustomer.setMailAddressCountry(request.getCustomerInfo().getContactInfo().getMailingInfo().getCountryname());
		sanctionCustomer.setMailAddressState(request.getCustomerInfo().getContactInfo().getMailingInfo().getState());
		sanctionCustomer.setMailAddressStreetLine1(request.getCustomerInfo().getContactInfo().getMailingInfo().getAddress1());
		sanctionCustomer.setMailAddressStreetLine2(request.getCustomerInfo().getContactInfo().getMailingInfo().getAddress2());
		sanctionCustomer.setMailAddressStreetLine3(request.getCustomerInfo().getContactInfo().getMailingInfo().getAddress3());
		sanctionCustomer.setMailAddressZipCode(request.getCustomerInfo().getContactInfo().getMailingInfo().getPostcode());
		sanctionCustomer.setPhoneNumber1(request.getCustomerInfo().getContactInfo().getContactNum1());
		sanctionCustomer.setPhoneNumber2(request.getCustomerInfo().getContactInfo().getContactNum2());
		sanctionCustomer.setPrimaryEmail(request.getCustomerInfo().getContactInfo().getPrimaryEmailId());
		sanctionCustomer.setResAddressCity(request.getCustomerInfo().getContactInfo().getResidentialInfo().getCity());
		sanctionCustomer.setResAddressCountry(request.getCustomerInfo().getContactInfo().getResidentialInfo().getCountryname());
		sanctionCustomer.setResAddressState(request.getCustomerInfo().getContactInfo().getResidentialInfo().getState());
		sanctionCustomer.setResAddressStreetLine1(request.getCustomerInfo().getContactInfo().getResidentialInfo().getAddress1());
		sanctionCustomer.setResAddressStreetLine2(request.getCustomerInfo().getContactInfo().getResidentialInfo().getAddress2());
		sanctionCustomer.setResAddressStreetLine3(request.getCustomerInfo().getContactInfo().getResidentialInfo().getAddress3());
		sanctionCustomer.setResAddressZipCode(request.getCustomerInfo().getContactInfo().getResidentialInfo().getPostcode());
		sanctionCustomer.setSecondaryEmail(request.getCustomerInfo().getContactInfo().getSecondaryEmailId());
		sanctionCustomer.setSecondName(request.getCustomerInfo().getSecondName());
		sanctionCustomer.setStatus("GREY_LIST");
		sanctionCustomer.setThirdName(request.getCustomerInfo().getThirdName());
		sanctionCustomer.setTransactionAmount(Double.parseDouble(request.getTransactionInfo().getTranxAmt()));
		sanctionCustomer.setTransactionNo(null);
		sanctionCustomer.setTransactionType(request.getTransactionInfo().getTranxType());
		sanctionCustomer.setUniqueId1(request.getCustomerInfo().getIdnum1());
		sanctionCustomer.setUniqueId2(request.getCustomerInfo().getIdnum2());
		return sanctionCustomer;
	}
	
	private CustAccMapNcore prepareCustAccMapNcore(SanctionRequest request, CustDimNcore custDimNcore, AccDimNcore accDimNcore)
	{
		logger.info("Preparing CustAccMapNcore.....");
		CustAccMapNcore custAccMapNcore = new CustAccMapNcore();
		custAccMapNcore.setAccDimNcore(accDimNcore);
		custAccMapNcore.setAccOwnershipCat(request.getCustomerAccountMap().getAccountOwnershipCat());
		custAccMapNcore.setCreatedBy(CREATED_BY);
		custAccMapNcore.setCreatedDt(new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
		custAccMapNcore.setCreatedDtTm(new java.sql.Timestamp(Calendar.getInstance().getTimeInMillis()));
		custAccMapNcore.setCustDimNcore(custDimNcore);
		return custAccMapNcore;
	}
	
	private CustPtyMapNcore prepareCustPtyMapNcore(SanctionRequest request, CustDimNcore custDimNcore, ExtPartyDimNcore extPartyDimNcore)
	{
		logger.info("PreparingCustPtyMapNcore.......");
		CustPtyMapNcore custPtyMapNcore = new CustPtyMapNcore();
		custPtyMapNcore.setCreatedBy(CREATED_BY);
		custPtyMapNcore.setCreatedDt(new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
		custPtyMapNcore.setCreatedDtTm(new java.sql.Timestamp(Calendar.getInstance().getTimeInMillis()));
		custPtyMapNcore.setCustDimNcore(custDimNcore);
		custPtyMapNcore.setExtPartyDimNcore(extPartyDimNcore);
		custPtyMapNcore.setRelatedPartyCustomerFlag(request.getCustomerPartyMap().getRelatedPartyCustomerFlag());
		custPtyMapNcore.setRelationshipCode(request.getCustomerPartyMap().getRelationshipCode());
		custPtyMapNcore.setRelationshipCodeDescription(request.getCustomerPartyMap().getRelationshipCodeDesc());
		return custPtyMapNcore;
	}
	
	public static void main(String ar[])
	{
		MatchingAttributeConfig config1 = new MatchingAttributeConfig();
		
		config1.setRequestAttributeName("first_name");
		config1.setMatchStrength("100");
		config1.setMatchType("FUZZY");
		
		MatchingAttributeConfig config2 = new MatchingAttributeConfig();
		
		config2.setRequestAttributeName("last_name");
		config2.setMatchStrength("100");
		config2.setMatchType("FUZZY");
		
		MatchingAttributeConfig config3 = new MatchingAttributeConfig();
		
		config3.setRequestAttributeName("full_name");
		config3.setMatchStrength("100");
		config3.setMatchType("DIRECT");
		
		List<MatchingAttributeConfig> configList = new ArrayList<>();
		configList.add(config1);
		configList.add(config2);
		configList.add(config3);
		
		Map<String, String> map = new HashMap<>();
		map.put("first_name", "Vivek");
		map.put("last_name", "Madan");
		map.put("full_name", "Vivek Madan");
		SanctionDataEndpoint endpoint = new SanctionDataEndpoint();
		System.out.println(endpoint.getFuzzyQuery(configList, map));
	}
}
