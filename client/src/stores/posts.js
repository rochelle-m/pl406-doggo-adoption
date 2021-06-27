import { writable } from "svelte/store";
import moment from "moment";
const URL = `/api/posts/`;

let posts;
fetch(URL)
  .then((response) => response.json())
  .then((data) => {
    posts = data;
    localStorage.setItem(
      "posts",
      JSON.stringify(
        posts?.sort(
          (a, b) =>
            moment(b.createdDate).format("X") -
            moment(a.createdDate).format("X")
        )
      )
    );
  })
  .catch((err) => console.log(err));

posts = JSON.parse(localStorage.getItem("posts"));

export const { subscribe, set, update } = writable(posts);
