<script>
  import Banner from "../utils/Banner.svelte";

  export let title = "Dog Adoption and Care · Events";

  let message = "Apply for Adoption";
  let imgSrc = "images/dog2.jpg";

  let dog_id = "";
  let name = "";
  let phone_number = "";
  let address = "";
  let occupation = "";
  let own_pet = "";
  let allergy = "";
  let noOfAdults = "";
  let noOfChildren = "";
  let typeOfHome = "";
  let describe_house = "";
  let whytoadopt = "";
  let have_time = "";
  let agreement = "";
</script>

<style>
  h3 {
    padding: 4em 0;
  }


  div.dog_id {
    display : none;
  }

  * {
  box-sizing: border-box;
}


label {
  padding: 12px 12px 12px 0;
  display: inline-block;
}

.submit_btn {
  background-color: #04AA6D;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  float: right;
}

.submit_btn:hover {
  background-color: blue;
}

.container {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}

.col-25 {
  float: left;
  width: 25%;
  margin-top: 6px;
}

.col-75 {
  float: left;
  width: 75%;
  margin-top: 6px;
}


.row:after {
  content: "";
  display: table;
  clear: both;
}

@media screen and (max-width: 600px) {
  .col-25, .col-75, input[type=submit] {
    width: 100%;
    margin-top: 0;
  }
}
</style>

<svelte:head>
  <title>{title}</title>
</svelte:head>

<div>
  <Banner {message} {imgSrc} />

  <br /><br />
  <div class="container">
    <form action="/action_page.php">
      <div class="row">
        <div class="col-25"><label for="dog_id"><b>Dog Id: </b></label></div>
        <div class="col-75">
          <input type="text" placeholder="Enter Dog Id" bind:value={dog_id} />
        </div>
      </div>

      <div class="row">
        <div class="col-25"><label for="name"><b>Name: </b></label></div>
        <div class="col-75">
          <input
            type="text"
            placeholder="Enter Name"
            bind:value={name}
            required />
        </div>
      </div>

      <div class="row">
        <div class="col-25">
          <label for="phone_number"><b>Phone Number: </b></label>
        </div>
        <div class="col-75">
          <input
            type="text"
            placeholder="Phone number"
            bind:value={phone_number}
            required
            pattern="[789][0-9]{9}" />
        </div>
      </div>

      <div class="row">
        <div class="col-25"><label for="address"><b>Address: </b></label></div>
        <div class="col-75">
          <input
            type="text"
            placeholder="Address"
            bind:value={address}
            required
            pattern="^[a-zA-Z]+([\s][a-zA-Z]+)+$" />
        </div>
      </div>

      <div class="row">
        <div class="col-25">
          <label for="occupation"><b>Occupation: </b></label>
        </div>
        <div class="col-75">
          <input
            type="text"
            placeholder="Occupation"
            bind:value={occupation}
            required />
        </div>
      </div>

      <div class="row">
        <div class="col-25">
          <label for="ownpet"><b>Have you previously owned pets? </b></label>
        </div>
        <div class="col-75">
          <input type="radio" bind:group={own_pet} value="Yes" />
          Yes
          <input type="radio" bind:group={own_pet} value="No" />
          No
        </div>
      </div>

      <div class="row">
        <div class="col-25">
          <label for="allergy"><b>Does anyone in the family have known allergy to
              dogs?
            </b></label>
        </div>
        <div class="col-75">
          <input type="radio" bind:group={allergy} value="Yes" />
          Yes
          <input type="radio" bind:group={allergy} value="No" />
          No
        </div>
      </div>

      <div class="row">
        <div class="col-25">
          <label for="ownpet"><b>Have you previously owned pets? </b></label>
        </div>
        <div class="col-75">
          <input type="radio" bind:group={own_pet} value="Yes" />
          Yes
          <input type="radio" bind:group={own_pet} value="No" />
          No
        </div>
      </div>

      <div class="row">
        <div class="col-25">
          <label for="noOfAdults"><b>How many adults are there in your
              family?(18+)</b></label>
        </div>
        <div class="col-75">
          <input
            type="number"
            placeholder="noOfAdults"
            bind:value={noOfAdults}
            required />
        </div>
      </div>

      <div class="row">
        <div class="col-25">
          <label for="noOfChildren"><b>How many children are there in your family?
            </b></label>
        </div>
        <div class="col-75">
          <input
            type="number"
            placeholder="noOfChildren"
            bind:value={noOfChildren}
            required />
        </div>
      </div>

      <div class="row">
        <div class="col-25">
          <label for="household"><b>What type of home do you live in? </b></label>
        </div>
        <div class="col-75">
          <input type="radio" bind:group={typeOfHome} value="House" />
          House
          <input type="radio" bind:group={typeOfHome} value="Flat" />
          Flat
          <input type="radio" bind:group={typeOfHome} value="Bunglow" />
          Bunglow
          <input type="radio" bind:group={typeOfHome} value="Farm house" />
          Farm house
        </div>
      </div>

      <div class="row">
        <div class="col-25">
          <label for="household"><b>Please describe your household:
            </b></label><br />
        </div>
        <div class="col-75">
          <input type="radio" bind:group={describe_house} value="Active" />
          Active
          <input type="radio" bind:group={describe_house} value="Noisy" />
          Noisy
          <input type="radio" bind:group={describe_house} value="Quiet" />
          Quiet
          <input type="radio" bind:group={describe_house} value="Average" />
          Average
        </div>
      </div>

      <div class="row">
        <div class="col-25">
          <label for="whytoadopt"><b>Why do you want to adopt this pet?
            </b></label>
        </div>
        <div class="col-75">
          <input
            type="checkbox"
            bind:group={whytoadopt}
            value="companionForSelf" />
          Companion For Self
          <input
            type="checkbox"
            bind:group={whytoadopt}
            value="companionForChild" />
          Companion For Child
          <input
            type="checkbox"
            bind:group={whytoadopt}
            value="companionForOtherDog" />
          Companion For Other Dog
          <input type="checkbox" bind:group={whytoadopt} value="Security" />
          Security
          <input type="checkbox" bind:group={whytoadopt} value="housePet" />
          House Pet
        </div>
      </div>

      <div class="row">
        <div class="col-25">
          <label for="time"><b>Do you have enough time to provide adequate love
              and affection?
            </b></label>
        </div>
        <div class="col-75">
          <input type="radio" bind:group={have_time} value="Yes" />
          Yes
          <input type="radio" bind:group={have_time} value="No" />
          No
        </div>
      </div>

      <div class="row">
        <div class="col-25">
          <label for="agreement"><b>Is everyone in agreement with the decision to
              adopt a dog?
            </b></label>
        </div>
        <div class="col-75">
          <input type="radio" bind:group={agreement} value="Yes" />
          Yes
          <input type="radio" bind:group={agreement} value="No" />
          No
        </div>
      </div>

      <div class="row">
        <div class="submit_btn"><input type="submit" value="Submit" /></div>
      </div>
    </form>
  </div>
</div>