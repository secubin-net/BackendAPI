package net.secubin.api.model

/**
 * Holds an encrypted message and additional information which should be send to a client by the API.
 */
class CryptMessageOut(content: String, type: String, salt: String, algorithm: String) : CryptMessage(content, type, salt, algorithm){
    companion object {
        /**
         * Created a new instance of the CryptMessageOut class and init all properties with empty values.
         */
        fun empty(): CryptMessageOut{
            return CryptMessageOut("","","","")
        }
    }
}