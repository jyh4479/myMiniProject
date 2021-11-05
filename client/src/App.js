import React from 'react';
import {BrowserRouter as Router, Redirect, Route, Switch} from 'react-router-dom'
import {HomePage, LoginPage, MyPage, SignUpPage} from "./pages";

const App = () => {
    return (
        <Router>
            <Route render={() => (
                <Redirect to={
                    !window.localStorage.getItem('access-token') && window.location.pathname !== '/login' ? '/login' : window.location.pathname
                }/>)}/>
            <Switch>
                <Route exact path={'/'} component={HomePage}/>
                <Route path={'/login'} component={LoginPage}/>
                <Route path={'/signup'} component={SignUpPage}/>
                <Route path={'/mypage'} component={MyPage}/>
            </Switch>
        </Router>
    );
}

export default App;
