package net.secubin.api.facade

import net.secubin.api.model.CryptMessage

/**
 * Provides methods to store EncryptedMessage in the data storage.
 */
interface IDoStore {

    /**
     * Stores the given message in the database and returns the ID of it, which is necessary to
     * receive it later. In case something goes wrong an exception will be thrown.
     */
    fun store(message: CryptMessage): String
}