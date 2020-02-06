public class GroupWithVersion {
    var group: Group
    var lastUpdatedDate: Int64

    init(group: Group, lastUpdatedDate: Int64) {
        self.group = group
        self.lastUpdatedDate = lastUpdatedDate
    }

    public static func from(_ notification: TurmsNotification) -> GroupWithVersion {
        return GroupWithVersion(
            group: notification.data.groupsWithVersion.groups[0],
            lastUpdatedDate: notification.data.groupsWithVersion.lastUpdatedDate.value
        )
    }
}
