import styled, { css } from 'styled-components';

export const LayoutHomeContainer = styled.div`
  ${({ theme }) => css`
    height: 100vh;
    @media only screen and ${theme.medias.mx} {
      grid-template-columns: 1fr;
    }
  `}
`;
// #layout_container {
//   display: grid;
//   /*grid-template-columns: minmax(150px, 25%) 1fr;*/
//   grid-auto-columns: 1fr;
//   grid-template-rows: 70px 1fr 70px;
//   grid-template-areas:
//     'Header'
//     'Main'
//     'Footer';
//   height: 100vh;

//   // @media screen and (max-width: 720px) {
//   //   grid-auto-columns: 1fr;
//   //   grid-template-rows: 60px 1fr 70px;

//   //   grid-template-areas:
//   //     'Header'
//   //     'Main'
//   //     'Footer';
//   // }
// }
