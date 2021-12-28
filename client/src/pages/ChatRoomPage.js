import React from 'react';
import {ChatRoom} from "../components/container";

const ChatRoomPage = props => {
    return <ChatRoom match={props.match} history={props.history}/>
}

export default ChatRoomPage