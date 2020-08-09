import * as React from 'react';
import './App.css';
import Home from './Home';
import { BrowserRouter as Router, Route } from 'react-router-dom';
import { Security, ImplicitCallback } from '@okta/okta-react';

const config = {
  issuer: 'https://dev-879975.okta.com/oauth2/default',
  redirect_uri: window.location.origin + '/implicit/callback',
  client_id: '0oa1dam8ebDLvIGmh357'
};

export interface Auth {
  login(redirectUri: string): {};
  logout(redirectUri: string): {};
  isAuthenticated(): boolean;
  getAccessToken(): string;
}

class App extends React.Component {

  render() {
    return (
      <Router>
        <Security {...config}>
          <Route path="/" exact={true} component={Home}/>
          <Route path="/implicit/callback" component={ImplicitCallback}/>
        </Security>
      </Router>
    );
  }
}

export default App;