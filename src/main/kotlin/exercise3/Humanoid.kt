package exercise3

abstract class Humanoid : HumAction {
    abstract var name: String // Имя
    abstract val voiceType: VoiceType
}

enum class HumanoidCondition {
    Calm,
    Panic,
    Excited,
    Charmed
}

enum class HandsStatus {
    Clean,
    Dirty,
    LeftBroken,
    RightBroken,
    BothBroken,
}

enum class VoiceType {
    tnin,
    soprano,
    baritone,
    tenor
}

interface HumAction {
    var actionStatus: Pair<ActionType, Any?>
    var handsStatus: HandsStatus
    var condition: HumanoidCondition // Состояние(настроение)

    infix fun doAction(action: ActionType): Boolean {
        actionStatus = Pair(action, null)
        return true
    }

    fun doAction(action: ActionType, obj: Any): Boolean {
        if (handsStatus == HandsStatus.BothBroken)
            return false
        actionStatus = Pair(action, obj)
        return true
    }

    fun getHandsDirty() {
        handsStatus = HandsStatus.Dirty
    }

    fun getHandsClean() {
        handsStatus = HandsStatus.Clean
    }

    fun calm(){
        condition = HumanoidCondition.Calm
    }


    infix fun screamAt(creature: Humanoid) {
        this.doAction(ActionType.Screaming)
        creature.condition = HumanoidCondition.Panic
    }

    infix fun hearVoice(creature: Humanoid): VoiceType {
        return creature.voiceType
    }

}