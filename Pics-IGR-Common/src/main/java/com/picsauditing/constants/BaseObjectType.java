package com.picsauditing.constants;
/**
 * Copyright (c) 2014. PICS Auditing LLC. All Rights Reserved.  This file is privileged, confidential and exempt from disclosure
 * under applicable law.  If you have received this file in error, please notify PICS Auditing LLC immediately, and destroy
 * the original file and all copies thereof (including electronic media).
 */

/**
 * Created by RNatarajan on 6/4/2014.
 * Modification Log :
 */

public enum BaseObjectType {

	INSUREGUARD("InsureGuard") {

		@Override
		public String getDescription() {
			return "InsureGuard";
		}

		@Override
		public boolean isActive() {
			return true;
		}

		@Override
		public Integer getIntValue(){
			return 10;
		}
	};
    private final String entity;

    private BaseObjectType(final String entity) {
        this.entity = entity;
    }

    public String getDescription() {
        return "";
    }

    public boolean isActive() {
        return false;
    }

	public Integer getIntValue(){
		return 99;
	}

    @Override
    public String toString() {
        return this.entity;
    }
}
