import { writable } from 'svelte/store';

function createUser () {
    const { subscribe, set, update } = writable({});

    return {
		subscribe,
		add: (newUser) => update(_ =>  ({...newUser, isLogged: true})),
		reset: () => set({})
	};
}

export const user = createUser()