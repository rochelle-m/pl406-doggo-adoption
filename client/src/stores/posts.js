import { writable } from "svelte/store";
import moment from "moment";

const posts = [
  {
    username: "linda",
    time: "5-15-2021",
    src: "images/3.jpg",
    comments: [
      {
        username: "karen",
        comment: "Oh so cute",
      },
      {
        username: "linda",
        comment: "The goooooodest",
      },
    ],
    caption: "caption caption",
  },
  {
    username: "joel",
    time: "6-7-2021",
    comments: [],
    caption: "Anyone knows something",
  },
  {
    username: "penny",
    time: "5-25-2021",
    src: "images/dog2.jpg",
    comments: [
      {
        username: "karen",
        comment: "Oh so cute",
      },
    ],
    caption: "cofds",
  },
];
// fetch if posts empty

export const { subscribe, set, update } = writable(
  posts.sort(
    (a, b) =>
      moment(b.time).format("YYYYMMDD") - moment(a.time).format("YYYYMMDD")
  )
);
