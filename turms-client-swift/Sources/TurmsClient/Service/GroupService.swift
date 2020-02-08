import Foundation
import PromiseKit

public class GroupService {
    private weak var turmsClient: TurmsClient!

    public init(_ turmsClient: TurmsClient) {
        self.turmsClient = turmsClient
    }

    public func createGroup(
        name: String,
        intro: String? = nil,
        announcement: String? = nil,
        profilePictureUrl: String? = nil,
        minimumScore: Int32? = nil,
        muteEndDate: Date? = nil,
        groupTypeId: Int32? = nil) -> Promise<Int64> {
        return turmsClient.driver
            .send(RequestBuilder.newInstance()
                .request("createGroupRequest")
                .field("name", name)
                .wrappedField("intro", intro)
                .wrappedField("announcement", announcement)
                .wrappedField("profilePictureUrl", profilePictureUrl)
                .wrappedField("minimumScore", minimumScore)
                .wrappedField("muteEndDate", muteEndDate)
                .wrappedField("groupTypeId", groupTypeId))
            .map { $0.data.ids.values[0] }
    }

    public func deleteGroup(groupId: Int64) -> Promise<Void> {
        return turmsClient.driver
            .send(RequestBuilder.newInstance()
                .request("deleteGroupRequest")
                .field("groupId", groupId))
            .map { _ in () }
    }

    public func updateGroup(
        groupId: Int64,
        groupName: String? = nil,
        intro: String? = nil,
        announcement: String? = nil,
        profilePictureUrl: String? = nil,
        minimumScore: Int32? = nil,
        groupTypeId: Int32? = nil,
        muteEndDate: Date? = nil,
        successorId: Int64? = nil,
        quitAfterTransfer: Bool? = nil) -> Promise<Void> {
        if Validator.areAllNil(
            groupName,
            intro,
            announcement,
            profilePictureUrl,
            minimumScore,
            groupTypeId,
            muteEndDate,
            successorId) {
            return Promise.value(())
        }
        return turmsClient.driver
            .send(RequestBuilder.newInstance()
                .request("updateGroupRequest")
                .field("groupId", groupId)
                .wrappedField("groupName", groupName)
                .wrappedField("intro", intro)
                .wrappedField("announcement", announcement)
                .wrappedField("profilePictureUrl", profilePictureUrl)
                .wrappedField("muteEndDate", muteEndDate)
                .wrappedField("minimumScore", minimumScore)
                .wrappedField("groupTypeId", groupTypeId)
                .wrappedField("successorId", successorId)
                .wrappedField("quitAfterTransfer", quitAfterTransfer))
            .map { _ in () }
    }

    public func transferOwnership(groupId: Int64, successorId: Int64, quitAfterTransfer: Bool = false) -> Promise<Void> {
        return turmsClient.driver
            .send(RequestBuilder.newInstance()
                .request("updateGroup")
                .field("groupId", groupId)
                .wrappedField("successorId", successorId)
                .wrappedField("quitAfterTransfer", quitAfterTransfer))
            .map { _ in () }
    }

    public func muteGroup(groupId: Int64, muteEndDate: Date) -> Promise<Void> {
        return turmsClient.driver
            .send(RequestBuilder.newInstance()
                .request("updateGroup")
                .field("groupId", groupId)
                .wrappedField("muteEndDate", muteEndDate))
            .map { _ in () }
    }

    public func unmuteGroup(groupId: Int64) -> Promise<Void> {
        return muteGroup(groupId: groupId, muteEndDate: Date(timeIntervalSince1970: 0))
    }

    public func queryGroup(groupId: Int64, lastUpdatedDate: Date? = nil) -> Promise<GroupWithVersion> {
        return turmsClient.driver
            .send(RequestBuilder.newInstance()
                .request("queryGroupRequest")
                .field("groupId", groupId)
                .wrappedField("lastUpdatedDate", lastUpdatedDate))
            .map { GroupWithVersion.from($0) }
    }

    public func queryJoinedGroupsIds(lastUpdatedDate: Date?) -> Promise<Int64ValuesWithVersion> {
        return turmsClient.driver
            .send(RequestBuilder.newInstance()
                .request("queryJoinedGroupsIdsRequest")
                .wrappedField("lastUpdatedDate", lastUpdatedDate))
            .map { $0.data.idsWithVersion }
    }

    public func queryJoinedGroupsInfos(lastUpdatedDate: Date? = nil) -> Promise<GroupsWithVersion> {
        return turmsClient.driver
            .send(RequestBuilder.newInstance()
                .request("queryJoinedGroupsInfosRequest")
                .wrappedField("lastUpdatedDate", lastUpdatedDate))
            .map { $0.data.groupsWithVersion }
    }

    public func addGroupJoinQuestion(groupId: Int64, question: String, answers: [String], score: Int32) -> Promise<Int64> {
        return turmsClient.driver
            .send(RequestBuilder.newInstance()
                .request("createGroupJoinQuestionRequest")
                .field("groupId", groupId)
                .field("question", question)
                .field("answers", answers)
                .field("score", score))
            .map { $0.data.ids.values[0] }
    }

    public func deleteGroupJoinQuestion(questionId: Int64) -> Promise<Void> {
        return turmsClient.driver
            .send(RequestBuilder.newInstance()
                .request("deleteGroupJoinQuestionRequest")
                .field("questionId", questionId))
            .map { _ in () }
    }

    public func updateGroupJoinQuestion(questionId: Int64, question: String? = nil, answers: [String]? = nil, score: Int32? = nil) -> Promise<Void> {
        if Validator.areAllNil(question, answers, score) {
            return Promise.value(())
        }
        return turmsClient.driver
            .send(RequestBuilder.newInstance()
                .request("updateGroupJoinQuestionRequest")
                .field("questionId", questionId)
                .wrappedField("question", question)
                .field("answers", answers)
                .wrappedField("score", score))
            .map { _ in () }
    }

    // Group Blacklist
    public func blacklistUser(groupId: Int64, userId: Int64) -> Promise<Void> {
        return turmsClient.driver
            .send(RequestBuilder.newInstance()
                .request("createGroupBlacklistedUserRequest")
                .field("blacklistedUserId", userId)
                .field("groupId", groupId))
            .map { _ in () }
    }

    public func unblacklistUser(groupId: Int64, userId: Int64) -> Promise<Void> {
        return turmsClient.driver
            .send(RequestBuilder.newInstance()
                .request("deleteGroupBlacklistedUserRequest")
                .field("groupId", groupId)
                .field("unblacklistedUserId", userId))
            .map { _ in () }
    }

    public func queryBlacklistedUsersIds(
        groupId: Int64,
        lastUpdatedDate: Date? = nil) -> Promise<Int64ValuesWithVersion> {
        return turmsClient.driver
            .send(RequestBuilder.newInstance()
                .request("queryGroupBlacklistedUsersIdsRequest")
                .field("groupId", groupId)
                .wrappedField("lastUpdatedDate", lastUpdatedDate))
            .map { $0.data.idsWithVersion }
    }

    public func queryBlacklistedUsersInfos(
        groupId: Int64,
        lastUpdatedDate: Date? = nil) -> Promise<UsersInfosWithVersion> {
        return turmsClient.driver
            .send(RequestBuilder.newInstance()
                .request("queryGroupBlacklistedUsersInfosRequest")
                .field("groupId", groupId)
                .wrappedField("lastUpdatedDate", lastUpdatedDate))
            .map { $0.data.usersInfosWithVersion }
    }

    // Group Enrollment
    public func createInvitation(groupId: Int64, inviteeId: Int64, content: String) -> Promise<Int64> {
        return turmsClient.driver
            .send(RequestBuilder.newInstance()
                .request("createGroupInvitationRequest")
                .field("groupId", groupId)
                .field("inviteeId", inviteeId)
                .field("content", content))
            .map { $0.data.ids.values[0] }
    }

    public func deleteInvitation(invitationId: Int64) -> Promise<Void> {
        return turmsClient.driver
            .send(RequestBuilder.newInstance()
                .request("deleteGroupInvitationRequest")
                .field("invitationId", invitationId))
            .map { _ in () }
    }

    public func queryInvitations(groupId: Int64, lastUpdatedDate: Date? = nil) -> Promise<GroupInvitationsWithVersion> {
        return turmsClient.driver
            .send(RequestBuilder.newInstance()
                .request("queryGroupInvitationsRequest")
                .field("groupId", groupId)
                .wrappedField("lastUpdatedDate", lastUpdatedDate))
            .map { $0.data.groupInvitationsWithVersion }
    }

    public func createJoinRequest(groupId: Int64, content: String) -> Promise<Int64> {
        return turmsClient.driver
            .send(RequestBuilder.newInstance()
                .request("createGroupJoinRequestRequest")
                .field("groupId", groupId)
                .field("content", content))
            .map { $0.data.ids.values[0] }
    }

    public func deleteJoinRequest(requestId: Int64) -> Promise<Void> {
        return turmsClient.driver
            .send(RequestBuilder.newInstance()
                .request("deleteGroupJoinRequestRequest")
                .field("requestId", requestId))
            .map { _ in () }
    }

    public func queryJoinRequests(groupId: Int64, lastUpdatedDate: Date? = nil) -> Promise<GroupJoinRequestsWithVersion> {
        return turmsClient.driver
            .send(RequestBuilder.newInstance()
                .request("queryGroupJoinRequestsRequest")
                .field("groupId", groupId)
                .wrappedField("lastUpdatedDate", lastUpdatedDate))
            .map { $0.data.groupJoinRequestsWithVersion }
    }

    /**
     * Note: Only the owner and managers have the right to fetch questions with answers
     */
    public func queryGroupJoinQuestionsRequest(
        groupId: Int64,
        withAnswers: Bool = false,
        lastUpdatedDate: Date? = nil) -> Promise<GroupJoinQuestionsWithVersion> {
        return turmsClient.driver
            .send(RequestBuilder.newInstance()
                .request("queryGroupJoinQuestionsRequest")
                .field("groupId", groupId)
                .field("withAnswers", withAnswers)
                .wrappedField("lastUpdatedDate", lastUpdatedDate))
            .map { $0.data.groupJoinQuestionsWithVersion }
    }

    public func answerGroupQuestions(questionIdsAndAnswers: [Int64: String]) throws -> Promise<Bool> {
        if questionIdsAndAnswers.isEmpty {
            throw TurmsBusinessError(.illegalArguments)
        }
        return turmsClient.driver
            .send(RequestBuilder.newInstance()
                .request("checkGroupJoinQuestionsAnswersRequest")
                .field("questionIdAndAnswer", questionIdsAndAnswers))
            .map { $0.data.success.value }
    }

    // Group Member
    public func addGroupMember(
        groupId: Int64,
        userId: Int64,
        name: String? = nil,
        role: GroupMemberRole? = nil,
        muteEndDate: Date? = nil) -> Promise<Void> {
        return turmsClient.driver
            .send(RequestBuilder.newInstance()
                .request("createGroupMemberRequest")
                .field("groupId", groupId)
                .field("userId", userId)
                .wrappedField("name", name)
                .field("role", role)
                .wrappedField("muteEndDate", muteEndDate))
            .map { _ in () }
    }

    public func quitGroup(groupId: Int64, successorId: Int64? = nil, quitAfterTransfer: Bool? = nil) -> Promise<Void> {
        return turmsClient.driver
            .send(RequestBuilder.newInstance()
                .request("deleteGroupMemberRequest")
                .field("groupId", groupId)
                .field("groupMemberId", turmsClient.userService.userId)
                .wrappedField("successorId", successorId)
                .wrappedField("quitAfterTransfer", quitAfterTransfer))
            .map { _ in () }
    }

    public func removeGroupMember(groupId: Int64, memberId: Int64) -> Promise<Void> {
        return turmsClient.driver
            .send(RequestBuilder.newInstance()
                .request("deleteGroupMemberRequest")
                .field("groupId", groupId)
                .field("groupMemberId", memberId))
            .map { _ in () }
    }

    public func updateGroupMemberInfo(
        groupId: Int64,
        memberId: Int64,
        name: String? = nil,
        role: GroupMemberRole? = nil,
        muteEndDate: Date? = nil) -> Promise<Void> {
        if Validator.areAllNil(name, role, muteEndDate) {
            return Promise.value(())
        }
        return turmsClient.driver
            .send(RequestBuilder.newInstance()
                .request("updateGroupMemberRequest")
                .field("groupId", groupId)
                .field("memberId", memberId)
                .wrappedField("name", name)
                .field("role", role)
                .wrappedField("muteEndDate", muteEndDate))
            .map { _ in () }
    }

    public func muteGroupMember(groupId: Int64, memberId: Int64, muteEndDate: Date) -> Promise<Void> {
        return updateGroupMemberInfo(
            groupId: groupId,
            memberId: memberId,
            muteEndDate: muteEndDate)
    }

    public func unmuteGroupMember(groupId: Int64, memberId: Int64) -> Promise<Void> {
        return muteGroupMember(
            groupId: groupId,
            memberId: memberId,
            muteEndDate: Date(timeIntervalSince1970: 0))
    }

    public func queryGroupMembers(groupId: Int64, withStatus: Bool = false, lastUpdatedDate: Date? = nil) -> Promise<GroupMembersWithVersion> {
        return turmsClient.driver
            .send(RequestBuilder.newInstance()
                .request("queryGroupMembersRequest")
                .field("groupId", groupId)
                .wrappedField("lastUpdatedDate", lastUpdatedDate)
                .wrappedField("withStatus", withStatus))
            .map { $0.data.groupMembersWithVersion }
    }

    public func queryGroupMembersByMembersIds(groupId: Int64, membersIds: [Int64], withStatus: Bool = false) -> Promise<GroupMembersWithVersion> {
        return turmsClient.driver
            .send(RequestBuilder.newInstance()
                .request("queryGroupMembersRequest")
                .field("groupId", groupId)
                .field("groupMembersIds", membersIds)
                .wrappedField("withStatus", withStatus))
            .map { $0.data.groupMembersWithVersion }
    }
}