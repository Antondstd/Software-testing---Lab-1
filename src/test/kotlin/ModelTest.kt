import exercise3.*
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class ModelTest {

    var artur = Human("Artur")
    val door = Door("243")
    var george = Monkey("George", type = TypeMonkey.Mandarill, wool = TypeWool.Short)

    @Test
    fun `human actions`() {
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
        assertAll(
            {
                george.getHandsClean()
                assertEquals(HandsStatus.Clean, george.handsStatus)
            },
            {
                george.getHandsDirty()
                assertEquals(HandsStatus.Dirty, george.handsStatus)
            }
        )
    }

    @Test
    fun `screaming at someone`() {
        assertAll(
            {
                george.calm()
                assertEquals(HumanoidCondition.Calm, george.condition)
            },
            {
                george screamAt artur
                assertEquals(ActionType.Screaming, george.actionStatus.first)
                assertEquals(HumanoidCondition.Panic, artur.condition)
            })

    }

    @Test
    fun `hearing voice`() {
        assertEquals(VoiceType.tnin, artur hearVoice george)
    }
}