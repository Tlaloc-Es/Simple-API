package com.tlaloc_es.simpleapi;
/**
 *\brief This class provides the different names of API Rest
 */
public enum HttpMethods {
	GET("GET"),
	POST("POST"),
	PUT("PUT"),
	DELETE("DELETE");


	/** \brief value of the exception type*/
    private final String value;
    
    HttpMethods(String value) {
        this.value = value;
        
    }
    
    /**
     * \brief Return the API Rest´s name.
     * @return TheAPI Rest´s name
     */
    public String value() { return value; }
}
