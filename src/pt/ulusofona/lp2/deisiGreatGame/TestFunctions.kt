package pt.ulusofona.lp2.deisiGreatGame

import org.junit.Test
import kotlin.test.assertEquals

var abyssesAndTools = arrayOf(
    arrayOf("1", "0", "2"),
    arrayOf("1", "1", "3"),
    arrayOf("1", "2", "4"),
    arrayOf("1", "3", "5"),
    arrayOf("1", "4", "6"),
    arrayOf("1", "5", "7"),
    arrayOf("0", "0", "8"),
    arrayOf("0", "1", "9"),
    arrayOf("0", "2", "10"),
    arrayOf("0", "3", "11"),
    arrayOf("0", "4", "12"),
    arrayOf("0", "5", "13"),
    arrayOf("0", "6", "14"),
    arrayOf("0", "7", "15"),
    arrayOf("0", "8", "16"),
    arrayOf("0", "9", "17"),
    arrayOf("0", "2", "18")
)

var playerInfo = arrayOf(
    arrayOf("28", "sra nene", "PHP; Java", "Purple"),
    arrayOf("31", "rob roche", "Java; C++; Python; Portugues", "Blue"),
    arrayOf("16", "Alb erto", "Beck", "Brown")
)




internal class TestFunctions {
    private val manager: GameManager = GameManager()
    @Test
    fun test01GetPlayer() {

        manager.createInitialBoard(playerInfo, 30, abyssesAndTools)

        val routerFn = router()
        val commandGetFn = routerFn.invoke(CommandType.GET)

        var result = commandGetFn?.invoke(manager, listOf("PLAYER", "sra"))
        assertEquals("28 | sra nene | 1 | No tools | Java; PHP | Em Jogo", result)

        result = commandGetFn?.invoke(manager, listOf("PLAYER", "Andre"))
        assertEquals("Inexistent player", result)
    }

    @Test
    fun test01GetPlayersByLanguage() {

        manager.createInitialBoard(playerInfo, 30, abyssesAndTools)

        val routerFn = router()
        val commandGetFn = routerFn.invoke(CommandType.GET)

        var result = commandGetFn?.invoke(manager, listOf("PLAYERS_BY_LANGUAGE", "Java"))
        assertEquals("sra nene,rob roche", result)

        result = commandGetFn?.invoke(manager, listOf("PLAYERS_BY_LANGUAGE", "Beck"))
        assertEquals("Alb erto", result)

    }

    @Test
    fun test01GetPolyglots() {

        manager.createInitialBoard(playerInfo, 30, abyssesAndTools)

        val routerFn = router()
        val commandGetFn = routerFn.invoke(CommandType.GET)

        val result = commandGetFn?.invoke(manager, listOf("POLYGLOTS", ""))
        assertEquals("sra nene:2\n" +
                "rob roche:4", result)

    }

    @Test
    fun test01GetMostUsedPositions() {

        manager.createInitialBoard(playerInfo, 30, abyssesAndTools)
        manager.moveCurrentPlayer(2)
        manager.reactToAbyssOrTool()
        manager.moveCurrentPlayer(3)
        manager.reactToAbyssOrTool()
        manager.moveCurrentPlayer(2)
        manager.reactToAbyssOrTool()
        manager.moveCurrentPlayer(1)
        manager.reactToAbyssOrTool()
        manager.moveCurrentPlayer(4)
        manager.reactToAbyssOrTool()
        manager.moveCurrentPlayer(3)
        manager.reactToAbyssOrTool()
        manager.moveCurrentPlayer(5)
        manager.reactToAbyssOrTool()
        manager.moveCurrentPlayer(1)
        manager.reactToAbyssOrTool()
        manager.moveCurrentPlayer(3)
        manager.reactToAbyssOrTool()
        manager.moveCurrentPlayer(6)
        manager.reactToAbyssOrTool()

        val routerFn = router()
        val commandGetFn = routerFn.invoke(CommandType.GET)

        val result = commandGetFn?.invoke(manager, listOf("MOST_USED_POSITIONS", "5"))
        assertEquals("9:2\n" +
                "8:2\n" +
                "4:2\n" +
                "3:2\n" +
                "15:1", result)


    }

    @Test
    fun test01GetMostUsedAbyss(){

        manager.createInitialBoard(playerInfo,30, abyssesAndTools)

        manager.moveCurrentPlayer(6)
        manager.reactToAbyssOrTool()
        manager.moveCurrentPlayer(6)
        manager.reactToAbyssOrTool()
        manager.moveCurrentPlayer(6)
        manager.reactToAbyssOrTool()
        manager.moveCurrentPlayer(1)
        manager.reactToAbyssOrTool()
        manager.moveCurrentPlayer(1)
        manager.reactToAbyssOrTool()
        manager.moveCurrentPlayer(2)
        manager.reactToAbyssOrTool()
        manager.moveCurrentPlayer(1)
        manager.reactToAbyssOrTool()
        manager.moveCurrentPlayer(3)
        manager.reactToAbyssOrTool()
        manager.moveCurrentPlayer(5)
        manager.reactToAbyssOrTool()

        val routerFn = router()
        val commandGetFn = routerFn.invoke(CommandType.GET)

        val result = commandGetFn?.invoke(manager, listOf("MOST_USED_ABYSSES", "10"))
        assertEquals("Erro de lógica:2\n" +
                "Erro de sintaxe:2\n" +
                "Efeitos secundários:1\n" +
                "File Not Found Exception:1\n" +
                "Exception:0\n" +
                "Segmentation Fault:0\n" +
                "Ciclo infinito:0\n" +
                "Blue Screen of Death:0\n" +
                "Duplicated Code:0\n" +
                "Crash (aka Rebentanço):0",result)

    }

    @Test
    fun test01PostMove(){

        manager.createInitialBoard(playerInfo,30, abyssesAndTools)

        val routerFn = router()
        val commandGetFn = routerFn.invoke(CommandType.POST)

        val result = commandGetFn?.invoke(manager, listOf("MOVE", "4"))

        assertEquals("Uhhh agora podes te safar de algumas exceções bem chatas *Tratamento de Excepções was added to your inventory*",result)
        assertEquals("[16 | Alb erto | 5 | Tratamento de Excepções | Beck | Em Jogo]",manager.getProgrammers(5).toString())

    }

    @Test
    fun test01PostAbyss(){
        manager.createInitialBoard(playerInfo,30, abyssesAndTools)

        val routerFn = router()
        val commandGetFn = routerFn.invoke(CommandType.POST)

        var result = commandGetFn?.invoke(manager, listOf("ABYSS", "3","23"))
        assertEquals("OK",result)
        assertEquals("0,3,23", manager.getBoardMap()[23].toString())

        result = commandGetFn?.invoke(manager,listOf("ABYSS","5","14"))

        assertEquals("Position is occupied",result)


    }
}


