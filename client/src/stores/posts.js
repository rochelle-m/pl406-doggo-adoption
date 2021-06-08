import { writable } from "svelte/store";

const posts = [
  {
    username: "linda",
    time: "3 days ago",
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
    time: "1 days ago",
    comments: [],
    caption: "Anyone knows something",
  },
  {
    username: "penny",
    time: "3 days ago",
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

export const { subscribe, set, update } = writable(posts);
