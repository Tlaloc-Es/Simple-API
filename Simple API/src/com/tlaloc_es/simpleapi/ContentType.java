package com.tlaloc_es.simpleapi;
/**
 *\brief This class provides different ContentType to make requests.
 */
public enum ContentType {
	JSON("application/json"),
	XML("application/xml");


	/** \brief value of the exception type*/
    private final String value;
    
    ContentType(String value) {
        this.value = value;
        
    }
    
    /**
     * \brief Return the content type value.
     * @return The content type value
     */
    public String value() { return value; }
}
