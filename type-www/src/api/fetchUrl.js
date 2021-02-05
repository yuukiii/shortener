async function fetchUrl(url) {
    return fetch("http://localhost:8080/url/shortener/postShort", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(url),
    }).then((data) => data.json());
}

export default fetchUrl;