import styled, { css } from 'styled-components';

export const LinkContainer = styled.a`
  & a {
    color: var(--white-100);
    font-size: 1.5rem;
    padding: 1rem;
    position: relative;
    text-transform: uppercase;
  }
  /* // &::after {
  //   content: '';
  //   position: absolute;
  //   bottom: 0;
  //   left: 50%;
  //   width: 0%;
  //   height: 0.2rem;
  //   background: red;
  //   transition: all 300ms ease-in-out;
  // }
  // &:hover::after {
  //   left: 25%;
  //   width: 50%;
  // } */
  a:active {
    font-weight: bold;
  }
`;
