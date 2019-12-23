package net.secubin.api.model

/**
 * Holds an encrypted message as well as all information necessary to store in a database and receive it later.
 */
class CryptMessageStore(content: String, type: String, salt: String, algorithm: String) : CryptMessage(content, type, salt, algorithm){
}