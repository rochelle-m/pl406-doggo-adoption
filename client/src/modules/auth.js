const API_URL = "http://localhost:5001/api/auth/";
import { authorize, create, put } from "./request";
import { user } from "../stores/user";

let logOn = {
  login: {
    title: "Login",
    banner: "/images/dog13.jpg",
    alt: "Sign Up",
    request: async (newUser) => {
      const response = await create(API_URL + "signin", {
        username: newUser.username,
        password: newUser.password,
      });
      try {
        const userData = await response.json();
      if (userData.token) {
        localStorage.setItem(
          "user",
          JSON.stringify({ ...userData, isLoggedIn: true })
        );
        user.add({ ...userData, isLoggedIn: true });
        return true;
      }
      }
      catch (err) {
        return false
      }
      return false;
    },
  },
  signup: {
    title: "Sign Up",
    banner: "/images/dog2.jpg",
    alt: "Login",
    request: async (newUser, vrole = null) => {
      try {
        const response = await create(API_URL + "signup", {
          username: newUser.username,
          password: newUser.password,
          email: newUser.email,
          roles: newUser.roles || ["user"],
          volunteerRole: vrole,
        });
        const userData = await response.json();
        if (userData.token) {
          localStorage.setItem(
            "user",
            JSON.stringify({ ...userData, isLoggedIn: true })
          );
          user.add({ ...userData, isLoggedIn: true });
          return true;
        }
      }
      catch (err) {
        return false;
      }
      return false;
    },
  },
};

let logout = async () => {
  let { type, token } = JSON.parse(localStorage.getItem("user"));
  try {
    await authorize(API_URL + "logout", type + " " + token);
    localStorage.removeItem("user");
    user.reset();
  }
  catch (err) {
    return false
  }
  return true
};

let update = async (role) => {
  const { type, token, id } = JSON.parse(localStorage.getItem("user"));
  const response = await put(
    `${API_URL}update/${id}/${role}`,
    type + " " + token
  );
  if (response.ok) {
    const roles = await response.json();
    const newRoles = roles.map((r) => r.role);

    const userData = JSON.parse(localStorage.getItem("user"));
    userData.roles = newRoles;
    localStorage.setItem(
      "user",
      JSON.stringify({ ...userData, isLoggedIn: true })
    );
    user.add({ ...userData, isLoggedIn: true });
  }
};

export { logOn, logout, update };
