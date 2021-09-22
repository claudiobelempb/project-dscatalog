import styled, { css } from 'styled-components';

export const NavContainer = styled.nav`
  ${({ theme }) => css`
    display: flex;
    /* background: ${theme.colors.red_100}; */
    color: ${theme.colors.white_100};

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

    @media only screen and ${theme.medias.mx} {
      grid-template-columns: 1fr;
    }
  `}
`;
