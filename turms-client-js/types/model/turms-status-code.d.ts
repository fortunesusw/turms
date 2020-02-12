declare enum Code {
    OK = 2000,
    NO_CONTENT = 2001,
    ALREADY_UP_TO_DATE = 2002,
    RECIPIENTS_OFFLINE = 2003,
    NOT_RESPONSIBLE = 3000,
    FAILED = 4000,
    DISABLED_FUNCTION = 4001,
    EXPIRY_DATE_BEFORE_NOW = 4002,
    EXPIRY_RESOURCE = 4003,
    ID_DUPLICATED = 4004,
    ILLEGAL_ARGUMENTS = 4005,
    ILLEGAL_DATE_FORMAT = 4006,
    NOT_ACTIVE = 4007,
    OWNED_RESOURCE_LIMIT_REACHED = 4008,
    REQUESTED_RECORDS_TOO_MANY = 4009,
    RESOURCES_HAVE_BEEN_HANDLED = 4010,
    RESOURCES_HAVE_CHANGED = 4011,
    SESSION_SIMULTANEOUS_CONFLICTS_DECLINE = 4012,
    SESSION_SIMULTANEOUS_CONFLICTS_NOTIFY = 4013,
    SESSION_SIMULTANEOUS_CONFLICTS_OFFLINE = 4014,
    SUCCESSOR_NOT_GROUP_MEMBER = 4015,
    TARGET_USERS_UNAUTHORIZED = 4016,
    TARGET_USERS_NOT_EXIST = 4017,
    TYPE_NOT_EXISTS = 4018,
    UNAUTHORIZED = 4019,
    REDUNDANT_REQUEST = 4020,
    ALREADY_GROUP_MEMBER = 4021,
    FRIEND_REQUEST_HAS_EXISTED = 4022,
    RELATIONSHIP_HAS_ESTABLISHED = 4023,
    SERVER_INTERNAL_ERROR = 5000,
    LOGGED_DEVICES_CANNOT_OFFLINE = 5001
}
declare class TurmsStatusCode {
    private static _code2ReasonMap;
    private code;
    private reason;
    constructor(code: number);
    static isSuccessCode(code: number | string | Code): boolean;
    static isErrorCode(code: number | string): boolean;
    static getReason(code: number): string;
}
declare const _default: typeof TurmsStatusCode & typeof Code;
export default _default;
