package nihk.clampeditemtouchhelper

enum class Group {
    RED,
    BLUE
}

sealed class Item {
    abstract val text: String
    abstract val group: Group
}

data class HeaderItem(override val text: String, override val group: Group) : Item()
data class ListItem(override val text: String, override val group: Group) : Item()

val sampleItems = listOf(
    HeaderItem(text = "Red team", group = Group.RED),
    ListItem(text = "adam", group = Group.RED),
    ListItem(text = "bilbo", group = Group.RED),
    ListItem(text = "cassius", group = Group.RED),
    ListItem(text = "dennis", group = Group.RED),
    ListItem(text = "eric", group = Group.RED),
    HeaderItem(text = "Blue team", group = Group.BLUE),
    ListItem(text = "freddy", group = Group.BLUE),
    ListItem(text = "geoffry", group = Group.BLUE),
    ListItem(text = "harold", group = Group.BLUE),
    ListItem(text = "ike", group = Group.BLUE),
    ListItem(text = "john", group = Group.BLUE)
)