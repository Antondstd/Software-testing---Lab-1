import exercise3.*
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class ModelTest {

    @Test
    fun `human actions`() {
        var artur = Human("Artur")
        val door = Door("243")
        artur.doAction(ActionType.Closing, door)
        assertAll(
            { assertEquals(ActionType.Closing, artur.actionStatus.first) },
            { assertEquals(door, artur.actionStatus.second) },
            {
                artur.doAction(ActionType.Chilling)
                assertEquals(ActionType.Chilling, artur.actionStatus.first)
            }
        )
    }

    @Test
    fun `monkey stats`() {
        var george = Monkey("George", type = TypeMonkey.Mandarill, wool = TypeWool.Short)
        assertAll(
            { assertEquals(HandsStatus.Clean, george.handsStatus) },
            {
                george.getDirty()
                assertEquals(HandsStatus.Dirty, george.handsStatus)
            }
        )
    }

    @Test
    fun `screaming at someone`() {
        var artur = Human("Artur")
        var george = Monkey("George", type = TypeMonkey.Mandarill, wool = TypeWool.Short)
        assertAll(
            { assertEquals(HumanoidCondition.Calm, george.condition) },
            {
                george screamAt artur
                assertEquals(ActionType.Screaming, george.actionStatus.first)
                assertEquals(HumanoidCondition.Panic, artur.condition)
            })

    }

    @Test
    fun `hearing voice`() {
        var artur = Human("Artur")
        var george = Monkey("George", type = TypeMonkey.Mandarill, wool = TypeWool.Short)
        assertEquals(VoiceType.tnin, artur hearVoice george)
    }
}