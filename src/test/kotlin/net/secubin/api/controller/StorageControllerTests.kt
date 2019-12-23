package net.secubin.api.controller

import net.secubin.api.facade.IDoGet
import net.secubin.api.facade.IDoStore
import net.secubin.api.model.CryptMessage
import net.secubin.api.model.CryptMessageOut
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.springframework.http.HttpStatus
import java.util.*

/**
 * Provides Unit Tests for the StorageController.
 */
class StorageControllerTests {
    lateinit var storageController: StorageController
    lateinit var doGet: IDoGet
    lateinit var doStore: IDoStore

    @BeforeEach
    fun setUp(){
        this.doGet = mock(IDoGet::class.java)
        this.doStore = mock(IDoStore::class.java)
        this.storageController = StorageController(this.doGet,this.doStore)
    }

    @Test
    fun putEncryptedMessage_MessageIsOk_CreatorCalledAndIdReturned(){
        // Arrange
        val inputMessage = mock(CryptMessage::class.java)
        Mockito.`when`(this.doStore.store(inputMessage)).thenReturn("AnId")

        // Act
        val result = this.storageController.putEncryptedMessage(inputMessage)

        // Assert
        assertEquals(HttpStatus.OK,result.statusCode)
        assertEquals("AnId",result.body)
    }

    @Test
    fun getEncryptedMessage_MessageIsNotStored_StatusNotFoundReturned(){
        // Arrange
        Mockito.`when`(this.doGet.get("AnId")).thenReturn(Optional.empty())

        // Act
        val result = this.storageController.getEncryptedMessage("AnId")

        // Assert
        assertEquals(HttpStatus.NOT_FOUND,result.statusCode)
    }

    @Test
    fun getEncryptedMessage_MessageIsStored_MessageAndStatusOkReturned(){
        // Arrange
        var expectedMessage = CryptMessageOut.empty()
        Mockito.`when`(this.doGet.get("AnId")).thenReturn(Optional.of(expectedMessage))

        // Act
        val result = this.storageController.getEncryptedMessage("AnId")

        // Assert
        assertEquals(HttpStatus.OK,result.statusCode)
        assertEquals(expectedMessage,result.body)
    }
}