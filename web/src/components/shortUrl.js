import React from 'react';

const ShortUrl = ({url, shortenedUrl}) => {
    return (
        <div className="card">
            <div className="card-body">
                <h6 className="card-subtitle mb-2 ">shortened url: <a href={url}>{shortenedUrl}</a></h6>
            </div>
        </div>

    )
};

export default ShortUrl