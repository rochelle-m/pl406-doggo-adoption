import { user } from "../stores/user";
import { put } from "./request";

const API_URL = "/api/doggos/update/";

let update = async (action, doggoId) => {
  const { type, token } = JSON.parse(localStorage.getItem("user"));
  const response = await put(
    `${API_URL}${action}/${doggoId}`,
    type + " " + token
  );
  console.log(response)
};

export { update };