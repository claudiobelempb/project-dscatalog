import styled, { css } from 'styled-components';

export const NavContainer = styled.nav`
  display: flex;
  height: 100%;
  ${({ theme: { colors, medias } }) => css`
    /* background: ${colors.red_100}; */
    color: ${colors.white_100};

    .active::before {
      content: '';
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

    & a {
      color: var(--white-100);
      font-size: 1.5rem;
      padding: 1rem;
      position: relative;
      text-transform: uppercase;
    }

    & a:hover {
      color: ${colors.black_100};
      background-color: ${colors.blue_rgba};
    }

    @media only screen and ${medias.mx} {
      display: block;
      grid-template-columns: 1fr;
    }
  `}
`;
