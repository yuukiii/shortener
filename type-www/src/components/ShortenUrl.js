import React, { useState } from "react";
import { LazyLoadImage } from "react-lazy-load-image-component";
import { FaUser, FaLock } from "react-icons/fa";
import fetchUrl from "../api/fetchUrl";

export default function ShortenUrl(){
    const [url, setUrl] = useState();
    const [shortenUrl, setShortenUrl] = useState();

    const handleSubmit = async (e) => {
        e.preventDefault();
        const data = await fetchUrl(
            url
        );
        console.log(data);
        setShortenUrl(data.message.message)
    };

    return (
        <div className="w-full h-screen flex items-center justify-center">
            <form
                className="fw-full md:w-1/3 bg-white rounded-lg"
                onSubmit={handleSubmit}
            >
                <div className="flex font-bold justify-center mt-6">
          {/*<span className="h-1 w-1">*/}
          {/*  <LazyLoadImage src="../../public/avatar.svg" alt="" />*/}
          {/*</span>*/}
                </div>
                <h2 className="text-3xl text-center text-gray-700 mb-4 py-5">
                    Shorten URL
                </h2>
                <div className="px-12 pb-10">
                    <div className="w-full mb-2">
                        <div className="flex items-center">
                            <input
                                type="text"
                                placeholder="URL"
                                className="-mx-6 px-8  w-full border rounded px-3 py-2 text-gray-700 focus:outline-none focus:border-indigo-500"
                                onChange={(e) => setUrl(e.target.value)}
                            />
                        </div>
                    </div>

                    <div className="mt-10">
                        <button
                            className="w-full py-2 rounded-full bg-green-600 text-gray-100 focus:outline-none focus:shodow-outline hover:bg-indigo-600 shadow-lg"
                            type="submit"
                        >
                            Get Tiny Url
                        </button>
                    </div>
                </div>
            </form>
            <div>
                <a href={url}>{shortenUrl}</a>
            </div>
        </div>
    );
}