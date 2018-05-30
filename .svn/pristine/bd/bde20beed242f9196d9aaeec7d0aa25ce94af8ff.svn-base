package com.sas.sanction.utils;

import com.sas.sanction.dto.Result;

public class BuildResponse {
	
	public static Result buildErrorResponse(String message) {
		return new Result(Constants.ERROR, message, null);
	}

	public static Result buildSuccessResponse(Object data) {
		return new Result(Constants.SUCCESS, null, data);
	}
	
	public static Result buildNullResponse(String message) {
		return new Result(Constants.NODATA, message, null);
	}

}