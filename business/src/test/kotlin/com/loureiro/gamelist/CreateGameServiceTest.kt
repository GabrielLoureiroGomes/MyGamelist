package com.loureiro.gamelist

import com.loureiro.gamelist.repository.GamelistRepository
import com.loureiro.gamelist.services.CreateGameService
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test

class CreateGameServiceTest {

    private val mockGamelistRepository = mockk<GamelistRepository>()
    private val service = CreateGameService(mockGamelistRepository)

    @Test
    fun `create game`() {
        //Setup
        val mockGame = mockGame()

        every { mockGamelistRepository.create(any()) } returns mockGame.id

        //Execution
        service.createGame(mockGame)

        //Assertion
        verify(exactly = 1) { mockGamelistRepository.create(any()) }
    }
}
