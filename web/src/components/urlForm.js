import React from 'react';



const URLForm = ({ url, handleSubmit, handleUrl}) => {



    return (
        <div className="card">
            <div className="card-body">
                <form onSubmit={handleSubmit}>
                    <input
                        type="text"
                        value={url}
                        onChange={event => handleUrl(event.target.value)}
                        placeholder="Enter URL"
                        required
                    />
                    <button>Go!</button>
                </form>
                <hr/>
            </div>
        </div>
    );
}

export default URLForm