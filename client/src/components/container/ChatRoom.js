import React, {useState} from 'react'
import SockJsClient from "react-stomp";
import {Chat, ChatInput} from "../presentational";
import {chatServiceApi} from "../../utils";
import "../../styles/ChatRoom.scss"

const ChatRoom = props => {

    const [messages, setMessages] = useState([]);
    const [user, setUser] = useState(null);

    const onMessageReceived = (msg) => {
        console.log("New Message Received!!", msg);
        setMessages(messages.concat(msg));
    };

    const handleMessageSubmit = (msg) => {
        chatServiceApi
            .sendMessage(user.name, msg)
            .then((res) => {
                console.log("sent", res);
            })
            .catch((e) => {
                console.log(e);
            });
    };

    const onConnected = () => {
        chatServiceApi
            .sendMessage("connect", user.name + " 님이 들어왔습니다.")
            .then((res) => {
                console.log("connected!", res);
            })
            .catch((e) => {
                console.log(e);
            });
    }

    const onDisconnected = () => {
        chatServiceApi
            .sendMessage("disconnect", user.name + " 님이 나갔습니다.")
            .then((res) => {
                console.log("disconnected!", res);
            })
            .catch((e) => {
                console.log(e);
            });
    }

    return (
        <div className="ChatContainer">
            {/*<button onClick={() => newWindow("http://localhost:5000/", user)}>button</button>*/}
            <SockJsClient
                url={"http://localhost:2821/test/"}
                topics={["/topic/group"]}
                onConnect={onConnected}
                onDisconnect={onDisconnected}
                onMessage={(msg) => onMessageReceived(msg)}
                debug={false}
            />
            <Chat messages={messages} currentUser={user}/>
            <ChatInput handleOnSubmit={handleMessageSubmit}/>
        </div>
    )
}

export default ChatRoom