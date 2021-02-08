import React, {Component} from 'react';
import URLForm from "./components/urlForm";
import ShortUrl from "./components/shortUrl";
import axios from "axios";


class App extends Component {

    state = {
        shortenedUrl: ``,
        url: ``
    };


    handleSubmit = event => {
        event.preventDefault()
        const url = this.state.url;
        axios.post(`http://10.0.0.99:8080/url/shortener/postShort`, JSON.stringify(url))
            .then((resp) => {
                console.log(resp.data)
                const shortenedUrl = resp.data.message.message
                this.setState({shortenedUrl: shortenedUrl})
            })
            .catch(err => {
                console.log(err)
                this.setState({shortenedUrl: "error"})
            })


    }

    handleUrl = url => {
        console.log(`change to url is: ${url}`)
        this.setState({url});
    }

    render() {
        return (
            // <Contacts contacts={this.state.contacts} />
            <div>
                <URLForm

                    url={this.state.url}
                    handleSubmit={this.handleSubmit}
                    handleUrl={this.handleUrl}
                />

                {this.state.url &&
                this.state.shortenedUrl &&
                this.state.shortenedUrl.length > 0 &&
                this.state.url.length > 10 && (

                <ShortUrl
                    url = {this.state.url}
                    shortenedUrl={this.state.shortenedUrl}
                />
                    )}
            </div>
        )
    }


    componentDidMount() {
        console.log(`app loaded`)
    }
}

export default App;
