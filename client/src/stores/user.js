import { writable } from "svelte/store";

const userObj = JSON.parse(localStorage.getItem("user"));

function createUser() {
  const { subscribe, set, update } = writable(userObj);

  return {
    subscribe,
    add: (newUser) => update((_) => newUser),
    reset: () => set({}),
  };
}

export const user = createUser();
