import Axios from "axios";

const api = Axios.create({
    baseURL: "http://localhost:2821/kafka",
});

const ChatServiceApi = {
    // getMessages: (groupId) => {
    //     console.log("Calling get messages from API");
    //     return api.get(`/messages/${groupId}`);
    // },

    sendMessage: (username, text, id) => {
        let msg = {
            author: username,
            content: text,
            from: id,
        };
        return api.post(`/publish`, msg, {
            headers: {"Content-Type": "application/json"},
        });
    },
};

export default ChatServiceApi;