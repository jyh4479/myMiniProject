import React, {useState} from "react";
import SockJsClient from "react-stomp";
import {chatServiceApi} from "../../utils";

// import "./styles.css";
import {Chat, ChatInput, ChatLogin} from "../presentational";


function ChatApp() {
    const [messages, setMessages] = useState([]);
    const [user, setUser] = useState(null);

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

    return (
        <>
            {user !== null ? (
                <div className="chat-container">
                    <SockJsClient
                        url={"http://localhost:2821/test/"}
                        topics={["/topic/group"]}
                        // onConnect={console.log("connected!")}
                        // onDisconnect={console.log("disconnected!")}
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