import React, {useState} from "react";
import SockJsClient from "react-stomp";
import {chatServiceApi, memberServiceApi} from "../../utils";
import "../../styles/ChatApp.scss"


import {Chat, ChatInput, ChatLogin} from "../presentational";


function ChatApp() {
    const [messages, setMessages] = useState([]);
    const [user, setUser] = useState(null);
    const memberId = memberServiceApi.getMemberId()

    const onMessageReceived = (msg) => {
        console.log("New Message Received!!", msg);
        setMessages(messages.concat(msg));
    };

    const handleLoginSubmit = (name) => {
        setUser({name: name, color: randomColor()});
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

    const randomColor = () => {
        return "#" + Math.floor(Math.random() * 0xffffff).toString(16);
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
    const newWindow = (url, user) => {
        window.open(url, user, 'width=430,height=500,location=no,status=no,scrollbars=yes');
        window.open(url, user, 'width=430,height=500,location=no,status=no,scrollbars=yes');
        return true
    }

    return (
        <>
            {user !== null ? (
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
            ) : (
                <ChatLogin handleOnSubmit={handleLoginSubmit}/>
            )}
        </>
    );
}

export default ChatApp;