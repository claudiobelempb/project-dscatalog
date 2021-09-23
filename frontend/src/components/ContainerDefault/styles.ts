import styled, { css } from 'styled-components';

export const LayoutContainer = styled.div`
  max-width: 100%;
  height: 100%;
  ${({ theme }) => css`
    @media only screen and ${theme.medias.mx} {
      grid-template-columns: 1fr;
    }
  `}
`;
