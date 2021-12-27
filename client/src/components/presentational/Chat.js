import React from "react";
import '../../styles/Chat.scss'

const Chat = props => {

    const {messages, currentUser} = props

    const formattingTimestamp = timestamp => {
        const date = new Date(timestamp);
        let hour = date.getHours() < 10 ? `0${date.getHours()}` : date.getHours();
        let min =
            date.getMinutes() < 10 ? `0${date.getMinutes()}` : date.getMinutes();
        return `${hour}:${min}`;
    };

    return (
        <div className='ChatScroll'>
            <div className='ChatBox'>
                {messages.map((msg) => {
                    if (msg.author === "connect" || msg.author === "disconnect") {
                        return (
                            <li className={"ConnectBubble"}>
                                <p>{msg.content}</p>
                            </li>
                        )
                    } else {
                        return (
                            <li
                                className={`ChatBubble ${
                                    msg.author === currentUser ? "Send" : "Receive"
                                }`}
                            >
                                <span>{msg.author}</span>
                                <p>{msg.content}</p>
                                <span>{formattingTimestamp(msg.timestamp)}</span>
                            </li>
                        )
                    }

                    // <li
                    //     className={`ChatBubble ${
                    //         msg.author === currentUser.name ? "Send" : "Receive"
                    //     }`}
                    // >
                    //     <span>{msg.author}</span>
                    //     <p>{msg.content}</p>
                    //     <span>{formattingTimestamp(msg.timestamp)}</span>
                    // </li>
                })}
            </div>
        </div>
    );
}

export default Chat;