import { writable } from "svelte/store";

export const isOpenPost = writable(false);

export let closeForm = () => {
  
  isOpenPost.update((_) => false);
  
};

export let openForm = () => {
  
  isOpenPost.update((_) => true);
  
};