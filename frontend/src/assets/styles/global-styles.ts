import { createGlobalStyle, css } from 'styled-components';

export const GlobalStyles = createGlobalStyle`
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  -webkit-box-align: center;
}
html, body ,#root {
  /* font-size: 62.5%; */
  min-height: 100%;
  display: flex;
  flex-direction: column;
  font-size: 1rem;
  font-family: 'Open Sans', sans-serif;

  ${({ theme }) => css`
    background: ${theme.colors.white_100};
    color: ${theme.colors.black_100};
  `}
  @media(max-width: 1080px) {
    font-size: 93.75%; //15px
  }
  @media(max-width: 720px) {
    font-size: 87.5%; // 14px
  }
}
h1, h2, h3, h4,h5, h6 {
  font-family: 'Montserrat', sans-serif;
  font-weight: 600;
}
button, a {
  cursor: pointer;
  color: inherit;
  transition: filter 0.2s;
  &:hover {
    filter: brightness(0.9);
  }
}
a {
  text-decoration: none;
  display: block;
}
body, input, textarea, select, button {
  border: 0;
  /* outline: 0; */
  font-family: var(--font_family), sans-serif;
  font-weight: 400;
}
ul {
  list-style: none;
}
img {
  max-width: 100%;
}
[disabled] {
  opacity: 0.6;
  cursor: not-allowed;
}
.deposit {
  color: #33CC95;
}
.withdraw {
  color: #E52E4D;
}
.react-modal-overlay {
  background-color: rgba(0, 0, 0, 0.5);
  position: fixed;
  top: 0;
  bottom: 0;
  right: 0;
  left: 0;
  display: flex;
  align-items: center;
  justify-content: center;
}
.react-modal-content {
  width: 100%;
  max-width: 576px;
  background-color: var(--light);
  padding: 3rem;
  position: relative;
  border-radius: 0.25rem;
}
.react-modal-close {
  position: absolute;
  right: 1.5rem;
  top: 1.5rem;
  border: 0;
  background-color: transparent;
  transition: filter 0.2s;
  &:hover {
    filter: brightness(0.2);
  }
}
/* Utilities */

/* Text Styles*/
.x-large {
  font-size: 4rem;
  line-height: 1.2;
  margin-bottom: 1rem;
}
.large {
  font-size: 3rem;
  line-height: 1.2;
  margin-bottom: 1rem;
}
.lead {
  font-size: 1.5rem;
  margin-bottom: 1rem;
}
.text-center {
  text-align: center;
}
.text-primary {
  color: var(--blue);
}
.text-dark {
  color: var(--dark);
}
.text-success {
  color: var(--success);
}
.text-danger {
  color: var(--danger);
}
.text-center {
  text-align: center;
}
.text-right {
  text-align: right;
}
.text-left {
  text-align: left;
}
/* Center All */
.flex_center {
  display: flex;
  flex-direction: column;
  width: 100%;
  margin: auto;
  justify-content: center;
  align-items: center;
}
.flex_end {
  flex-direction: column;
  justify-content: flex-end;
  align-items: flex-end;
}
.flex_start {
  flex-direction: column;
  justify-content: flex-start;
  align-items: flex-start;
}
/* Cards */
.card {
  padding: 1rem;
  border: #ccc 1px dotted;
  margin: 0.7rem 0;
}
/* List */
.list {
  margin: 0.5rem 0;
}
.list li {
  padding-bottom: 0.3rem;
}
/* Padding */
.p {
  padding: 0.5rem;
}
.p-1 {
  padding: 1rem;
}
.p-2 {
  padding: 2rem;
}
.p-3 {
  padding: 3rem;
}
.py {
  padding: 0.5rem 0;
}
.py-1 {
  padding: 1rem 0;
}
.py-2 {
  padding: 2rem 0;
}
.py-3 {
  padding: 3rem 0;
}
/* Margin */
.m {
  margin: 0.5rem;
}
.m-1 {
  margin: 1rem;
}
.m-2 {
  margin: 2rem;
}
.m-3 {
  margin: 3rem;
}
.my {
  margin: 0.5rem 0;
}
.my-1 {
  margin: 1rem 0;
}
.my-2 {
  margin: 2rem 0;
}
.my-3 {
  margin: 3rem 0;
}
/* Grid */
.grid-1 {
  display: grid;
  grid-template-columns: 10rem 1fr 15rem;
  width: 100%;
  height: 100%;
  align-items: center;
}
.grid-2 {
  display: grid;
  grid-template-columns: repeat(2, 1fr);
  grid-gap: 1rem;
  height: 100%;
  align-items: center;
}
.grid-3 {
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  grid-gap: 1rem;
  height: 100%;
  align-items: center;
}
.grid-4 {
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  grid-gap: 1rem;
  height: 100%;
  align-items: center;
}
.btn {
  height: auto;
  border: none;
  width: 100%;
  display: flex;
  justify-content: center;
  // align-items: center;
}
.btn-link {
  background: none;
  padding: 0;
  margin: 0;
}
.btn-block {
  display: block;
  width: 100%;
}
.btn-small {
  font-size: 0.8rem;
  font-weight: 700;
  height: 3rem;
  padding: 0.3rem 1rem;
  margin-right: 0.2rem;
  max-width: 12rem;
  min-width: 12rem;
}
.btn-medium {
  font-size: 1.2rem;
  font-weight: 700;
  height: 3.5rem;
  padding: 0.3rem 1rem;
  margin-right: 0.2rem;
  max-width: 16rem;
  min-width: 16rem;
}
.btn-large {
  font-size: 1.2rem;
  font-weight: 700;
  height: 4rem;
  padding: 0.3rem 1rem;
  margin-right: 0.2rem;
  max-width: 20rem;
  min-width: 20rem;
}
.badge {
  display: inline-block;
  font-size: 0.8rem;
  padding: 0.2rem 0.7rem;
  text-align: center;
  margin: 0.3rem;
  background: var(--light);
  color: #333;
  border-radius: 5px;
}
.alert {
  padding: 0.7rem;
  margin: 1rem 0;
  opacity: 0.9;
  background: var(--light);
  color: #333;
}
.border-radius {
  border-radius: 2.5rem;
}
.border-bottom {
  border-bottom: 0.01rem solid var(--gray-10);
}
.btn-green,
.bg-green,
.badge-green,
.alert-green {
  background: var(--green-100);
  color: var(--white-100);
}
.btn-gray,
.bg-gray,
.badge-gray,
.alert-gray {
  background: var(--gray-100);
  color: var(--white-100);
}
.btn-yellow,
.bg-yellow,
.badge-yellow,
.alert-yellow {
  background: var(--yellow-50);
  color: var(--dark-100);
}
.btn-light,
.bg-light,
.badge-light,
.alert-light {
  background: var(--light);
  color: #333;
}
.btn-dark,
.bg-dark,
.badge-dark,
.alert-dark {
  background: var(--dark);
  color: #fff;
}
.btn-danger,
.bg-danger,
.badge-danger,
.alert-danger {
  background: var(--danger);
  color: #fff;
}
.btn-success,
.bg-success,
.badge-success,
.alert-success {
  background: var(--success);
  color: #fff;
}
.btn-white,
.bg-white,
.badge-white,
.alert-white {
  background: #fff;
  color: #333;
  border: #ccc solid 1px;
}
.btn:hover {
  opacity: 0.8;
}
.bg-light,
.badge-light {
  border: #ccc solid 1px;
}
.round-img {
  border-radius: 50%;
}
.form-text {
  display: block;
  margin-top: 0.3rem;
  color: #888;
}
/* Navbar */
.navbar {
  display: flex;
  // padding: 0.7rem 2rem;
  z-index: 1;
  width: 100%;
  height: 100%;
  // opacity: 0.9;
  // margin-bottom: 1rem;
}
.navbar ul {
  position: relative;
  display: flex;
  width: 100%;
  height: 100%;
}
.navbar a {
  display: flex;
  justify-content: space-between;
  align-items: center;
  color: #fff;
  padding: 0.45rem;
  margin: 0 0.25rem;
  height: 100%;
}
.navbar a:hover {
  color: var(--white-100);
}
.navbar a:active {
  color: var(--white-100);
  font-weight: 700;
}
.navbar  .active::before {
  content: "";
  position: absolute;
  border-bottom: 2px;
  background: var(--yellow-50);
  width: 38px;
  height: 3px;
  /* display: block; */
  /* top: 0; */
  // left: 0;
  bottom: 0;
  // border: 3px solid red
  border-radius: 10px 10px 0px 0px;
}
.navbar .welcome span {
  margin-right: 0.6rem;
}
/* Mobile Styles */
@media (max-width: 700px) {
  .hide-sm {
    display: none;
  }
  .grid-1,
  .grid-2,
  .grid-3,
  .grid-4 {
    grid-template-columns: 1fr;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
  }
  /* Text Styles */
  .x-large {
    font-size: 3rem;
  }
  .large {
    font-size: 2rem;
  }
  .lead {
    font-size: 1rem;
  }
  /* Navbar */
  .navbar {
    display: flex;
    text-align: center;
  }
  .navbar ul {
    text-align: center;
    justify-content: center;
    align-items: center;
  }
  .flex_end {
    flex-direction: column;
    align-items: center;
  }
  .flex_start {
    flex-direction: column;
    align-items: center;
  }
}

@media (max-width: 500px) {
  .btn-small,
  .btn-medium,
  .btn-large {
    // max-width: 100%;
    max-width: 100%;
  }
  .flex_end {
    flex-direction: column;
    align-items: center;
  }
  .flex_start {
    flex-direction: column;
    align-items: center;
  }
}

.font-zero {
  font-size: 0;
}

.shadow {
  box-shadow: 0px 4px 20px 0px rgba(0,0,0,0.25) !important;
  -webkit-box-shadow: 0px 4px 20px 0px rgba(0,0,0,0.25);
  -moz-box-shadow: 0px 4px 20px 0px rgba(0,0,0,0.25);
}

.box-shadow  {
  position: relative;
  right: 0;
  height: 750px;
  left: 0;
  top: 30px;
  padding: 5rem;
  border-radius: 1.25rem;
}
`;
