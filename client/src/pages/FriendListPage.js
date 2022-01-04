import React from 'react';
import {FriendList} from "../components/container";

const ChatRoomPage = props => {
    return <FriendList history={props.history}/>
}

export default ChatRoomPage