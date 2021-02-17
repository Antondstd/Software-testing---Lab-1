package exercise3

class Door(var id: String, private var status: DoorStatus = DoorStatus.Closed) {
    fun close() {
        status = DoorStatus.Closed
    }

    fun open() {
        status = DoorStatus.Open
    }

}


enum class DoorStatus {
    Crooked,
    Broken,
    Closed,
    Open
}