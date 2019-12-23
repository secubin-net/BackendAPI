package net.secubin.api.model

/**
 * An abstract base class which stores an encrypted message as well as all information necessary to decrypt it.
 */
abstract class CryptMessage(var content:String, var type:String, var salt:String, var algorithm:String) {
}