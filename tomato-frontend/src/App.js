import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import axios from 'axios';

class App extends Component {

  constructor(props) {
    super(props);

    this.state = {
      sales: [],
      input: ''
    };

    this.handleChange = this.handleChange.bind(this);
    this.handleClick = this.handleClick.bind(this);
  }

  componentDidMount() {
    this.callApi();
  }

  callApi(size) {
    let request = "http://localhost:8080/sales/data";
    if (size) {
      request += "?size=" + size;
    }
    axios.get(request)
      .then(res => {
        this.setState({sales: res.data});
      });
  }

  handleChange(e) {
    this.setState({input: e.target.value});
  }

  handleClick() {
    this.callApi(this.state.input);
  }

  render() {
    return (
      <div className="App">
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <h1 className="App-title">Welcome to Tomato Business inc.</h1>
        </header>

        <div className="sales-control">
          <span>Size:</span>
          <input id="textInput" type="text" onChange={this.handleChange}/>
          <input
            id="submit"
            type="button"
            value="Refresh"
            onClick={this.handleClick}
          />
        </div>

        <table className="sales">
          <tbody>
            <tr>
              <th>Provider</th>
              <th>Tomatoes</th>
              <th>Sale date</th>
            </tr>
            {this.state.sales.map(sale =>
              <tr>
                <td>{sale.provider}</td>
                <td>{sale.tomatoes}</td>
                <td>{new Date(sale.timestamp).toLocaleDateString()}</td>
              </tr>
            )}
          </tbody>
        </table>
      </div>
    );
  }
}

export default App;
