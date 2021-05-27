import { writable } from "svelte/store";

export const login = writable(false);
export const signup = writable(false);
export const volunteerRole = writable(null);

let prevBodyPosition;
let prevBodyOverflow;

export const openModal = (type, role=null) => {
  disableScroll();
  volunteerRole.update(() => role) 
   
  if (type === "login") {
    login.update((_) => true);
    signup.update((_) => false);
  }
  if (type === "signup") {
    signup.update((_) => true);
    login.update((_) => false);
  }
};

export let close = () => {
  enableScroll();
  login.update((_) => false);
  signup.update((_) => false);
};

const disableScroll = () => {
  scrollY = window.scrollY;
  prevBodyPosition = document.body.style.position;
  prevBodyOverflow = document.body.style.overflow;
  document.body.style.position = "fixed";
  document.body.style.top = `-${scrollY}px`;
  document.body.style.overflow = "hidden";
};

const enableScroll = () => {
  document.body.style.position = prevBodyPosition || "";
  document.body.style.top = "";
  document.body.style.overflow = prevBodyOverflow || "";
  window.scrollTo(0, scrollY);
};
