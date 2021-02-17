package exercise3

import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType

class Human(
    override var name: String,
    override var condition: HumanoidCondition = HumanoidCondition.Calm,
    override var handsStatus: HandsStatus = HandsStatus.Clean,
    override var actionStatus: Pair<ActionType, Any?> = Pair(ActionType.Chilling, null),
    override val voiceType: VoiceType = VoiceType.baritone,
) : Humanoid()

