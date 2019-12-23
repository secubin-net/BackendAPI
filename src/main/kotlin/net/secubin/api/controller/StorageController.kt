package net.secubin.api.controller

import net.secubin.api.facade.IDoGet
import net.secubin.api.facade.IDoStore
import net.secubin.api.model.CryptMessage
import net.secubin.api.model.CryptMessageOut
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RestController

/**
 * A spring RestController which provides API Access to store and receive encrypted Messages.
 */
@RestController
class StorageController @Autowired constructor(private val doGet: IDoGet,
                                               private val storedDo: IDoStore) {


    /**
     * Stores the given message and returns a unique id to receive it (together with a Status 200)
     */
    @PutMapping("/api/store")
    fun putEncryptedMessage(message: CryptMessage): ResponseEntity<String>{
        val id = this.storedDo.store(message)
        return ResponseEntity.ok(id);
    }

    /**
     * Returns the message stored behind the given id and a Status 200, or a status 404 in case no such message
     * was found.
     */
    @PutMapping("api/get")
    fun getEncryptedMessage(@PathVariable id: String): ResponseEntity<CryptMessageOut>{
        val message = this.doGet.get(id)
        return if (!message.isPresent) {
            ResponseEntity(HttpStatus.NOT_FOUND)
        } else {
            ResponseEntity.ok(message.get());
        }
    }
}