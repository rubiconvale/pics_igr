package com.picsauditing.data.security.constants;

public enum SecurityStatusType {

    BADCREDENTTIALS("Invalid Password") {

        @Override
        public String getDescription() {
            return "The password provided does not match our records";
        }
    },
    AUTHENTICATION("Invalid Username") {

        @Override
        public String getDescription() {
            return "The username provided is incorrect, please verify you have entered a valid username";
        }
    },
    INVALIDEMAIL("Invalid Email") {

        @Override
        public String getDescription() {
            return "The email provided does not match our records for your user";
        }
    },
    SUCCESSEMAIL("Email Success") {

        @Override
        public String getDescription() {
            return "A message containing instructions on username / password information has been sent to the email provided";
        }
    };
    private final String exception;

    private SecurityStatusType(final String exception) {
        this.exception = exception;
    }

    public String getDescription() {
        return "";
    }

    @Override
    public String toString() {
        return this.exception;
    }

}
